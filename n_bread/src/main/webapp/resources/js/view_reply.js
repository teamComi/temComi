var veiwArr = [];

document.addEventListener("DOMContentLoaded", function(){
    var viewReply = new View_reply();
    viewReply.buttonEvent();
})

function View_reply(){
    
}

View_reply.prototype = {
    connSelect : function(panum, page) {
        $.ajax({
            url : '/comi/partycosel?panum=' + panum + '&page=' + page
            ,type : 'get'
            ,dataType : 'json'
            ,success : function(data){
                
                var str = JSON.stringify(data);
                var json = JSON.parse(str);
                var value = '';
                console.log('json.paging : ' + json.paging);
                console.log('json.list : ' + json.list);

                $('#review_number').html(reviewLength + '개의 댓글');

                //댓글 리스트 불러오기
                for(var i=0; i<json.list.length; i++) {
                    var obj = json.list[i];
                    console.log('i : ' + i);
                    //$('').append(this.setReply(obj));
                }
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })
        
    }
    ,
    connInsert : function(depth, panum, parent, content){
        $.ajax({
            url : '/comi/partycoins?panum=' + panum + '&depth=' + depth + '&parent=' + parent + '&content=' + content
            ,type : 'get'
            ,dataType : 'json'
            ,success : function(data){
                
                var str = JSON.stringify(data);
                var json = JSON.parse(str);
                var value = '';
                console.log('json.paging : ' + json.paging);
                console.log('json.list : ' + json.list);

                //$('#review_number').html(reviewLength + '개의 댓글');
                $('.review-body').empty();
                //댓글 리스트 불러오기
                var len = json.list.length;
                for(var i=0; i<len; i++) {
                    var obj = json.list[i];
                    var nextDepth = (i < len-1) ? json.list[i+1].comDepth : -1;
                    console.log('i : ' + i);
                    $('.review-body').append(this.setReply(this.setTag(obj, nextDepth, len, i)));
                }
                
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })
    }
    ,
    
    setTag : function(data, nextDepth, len, i) {

        var myNick = 'donki2';
        var login = 'login'

        var tag1 = (data.depth == 1) ? 'reviewbody-first' : 'reviewbody-second';
        var el = 
        `<!--댓글 첫번째-->
        <div class="review-body-container `+tag1+` review_parent_`+data.comParent+`">

            <div class="review-body-box">
            
            <div class="review-body-list">
                <div class="review-body-list-profile">
                    <img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
                    <div class="review-body-list-profile-box">
                        <div class="review-body-list-name">`+data.meName+`</div>
                        <div class="review-body-list-date">`+data.comEnroll+`</div>
                    </div>
                </div>
                <div class="review-body-list-right">
                    <button class="review-body-list-right-btn">
                        <img class="review-body-list-right-btn-img" src="/comi/resources/images/1.png">
                    </button>
                </div>
            </div>

            <div class="review-body-read">
                <div class="review-body-read-text">
                    `+data.comCon+`
                </div>
            </div>

            <div class="review-body-bottom">
                <button class="review-body-bottom-retext review_parent_`+data.comParent+`" data-parent="`+data.comParent+`" >
                    하트 <b>`+data.comCount+`</b>
                </button>
                <div class="review-body-bottom-heartbox">
                    <button class="review-body-bottom-heart">
                        <img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
                    </button>
                    <span class="review-body-heart">
                        `+data.comViews+`
                    </span>
                </div>
            </div>

        </div>
        <!--댓글 첫번째 end-->`
        
        if(data.comDepth == 2 && (nextDepth == 1 || i == len-1 )){
            if(login == 'login'){
                el += `
                <!--댓글 쓰기-->
                <div class="review-write review-rewriting review_parent_` +data.comParent+ `" data-parent="` +data.comParent+ `">
                    <form>
                        <fieldset>
                            <legend class="u_vc">댓글 쓰기</legend>
                            <div class="review-write-inner review_mynum_` +data.comNum+ `" data-panum="` +data.paNum+ `" data-mynum="` +data.comNum+ `">
                                
                                <div class="review-write-profilearea">
                                    <div class="review-write-profile">
                                        <img src="/comi/resources/images/deafault.png" class="img-profile">
                                        <span class="write-name">`+myNick+`</span>
                                    </div>
                                </div>
        
                                <div class="review-write-area">
                                    <div class="review-write-area-inbox">
                                        <textarea title="댓글" class="review-write-textarea" rows="3" cols="30"></textarea>
                                        <label for="review_write_textarea_2" class="u_cbox_guide">
                                            다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
                                            모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
                                        </label>
                                    </div>
                                </div>
                                
                                <div class="review-write-count-box">
                                    <div class="review-write-count">
                                        <strong class="review-write-count-num">0</strong>/
                                        <span class="review-write-count-total">300</span>
                                    </div>
                                    <input type="button" class="review-write-upload" value="등록">
                                </div>
                            
                            </div>
                        </fieldset>
                    </form>
                </div>
                <!--댓글 쓰기 end--> `
            }else{
                el += `
                <div class="review-write-inner review-write-inner-reply review_parent_` +data.comParent+ `">
                    <div class="review-write-oucontainer">
                        <textarea title="댓글" id="review-write-outtext" class="review-write-outbox" rows="3" cols="30"></textarea>
                        <label for="review-write-outtext" class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                    </div>
                </div>`
            }

            el += `
            <button class="review-fold-btn review_parent_` +data.comParent+ `" data-parent="` +data.comParent+ `">
                <span class="review-fold-btn-text">답글 접기</span>
            </button>`
        }
    }
    

    ,
    buttonEvent : function(){
        
        var _this = this;
        $('.review-body-bottom-retext').each(function(){
            
        })
        
        $('.review-write-inner-login').each(function(){
            $(this).on('click', function(){
            
                if(confirm('로그인을 하신 후 이용해 주시기 바랍니다.')) {
                    //로그인 페이지로 이동
                    location.href = '/comi/main.jsp';
                }else{
    
                }
            })
        })

        //댓글쓰기
        $('.review-write-textarea').each(function(){
            $(this).on('input', function(){
                var reviewInner = $(this).parent().parent().parent('.review-write-inner');
                var mynum = reviewInner.attr('data-mynum');
                
                console.log(mynum + ' 댓글 길이 ');
                if($(this).val().length > 0) {
                    reviewInner.find('.u_cbox_guide').hide();
                    reviewInner.find('.review-write-upload').css({'background' : 'rgb(100, 166, 245)'});//#64A6F5
                }else{
                    reviewInner.find('.u_cbox_guide').show();
                    reviewInner.find('.review-write-upload').css({'background' : '#b0b3be'});//#64A6F5
                    
                }
                
                reviewInner.find('.review-write-count-num').text($(this).val().length);
            })
        })
        
        //댓글 등록
        $('.review-write-upload').each(function(){
            $(this).on('click', function(){
                if($(this).css('background-color') == 'rgb(100, 166, 245)') {
                    var reviewInner = $(this).parent().parent('.review-write-inner');
                    var textarea = reviewInner.find('.review-write-textarea');
                    var writeName = reviewInner.find('.write-name');
                    var panum, comparent, depth;

                    if($(this).attr('id') == 'party_reply_btn') {
                        //파티 뎁스1 댓글 달기
                        panum = reviewInner.attr('data-mynum');
                        comparent = -1;
                        depth = 1;
                        
                    }else{
                        //파티 뎁스2 댓글 달기
                        panum = reviewInner.attr('data-panum');
                        comparent = reviewInner.attr('data-parent');
                        depth = 2;

                    }
                    console.log('comparent : ' + comparent);
                    var data = {
                        comDepth : depth//1일때는 파티의 댓글 2일때는 댓글의 댓글
                        ,paNum : panum
                        ,comParent : comparent
                        ,comCon : textarea.val()
                        ,comCount : 0
                        ,comViews : 0
                        ,comEnroll : ''
                        ,meName : writeName.text()
                        //,member : member
                    }
                    console.log('댓글 달기 depth : ' + depth + ' panum : ' + panum + ' comparent : ' + comparent + ' content : ' + textarea.val());
                    veiwArr.push(data);
                    
                    if($(this).attr('id') == 'party_reply_btn') {
                        //파티 뎁스1 댓글 달기
                        $('.review-body').prepend(_this.setTag1(data));
                    }else{
                        //파티 뎁스2 댓글 달기
                        var area = $('.review-reply-area.area_parent_'+comparent);
                        console.log(area);
                        area.prepend(_this.setTag1(data));
                        area.find('.reviewbody-second').each(function(){
                            $(this).show();
                        });
                    }
                }
                return false;
            });
        })
        
        //댓글보기
        $('.review-body-bottom-retext').each(function(){
            $(this).on('click', function(){
                var myParent = $(this).attr('data-parent');
                console.log('myParent : ' + myParent);
                var visible = $('.reviewbody-second.review_parent_'+myParent).eq(0).css('display');
                _this.showReply(myParent, (visible == 'none') ? true : false);
            })
        })

        //댓글 접기
        $('.review-fold-btn').each(function(){
            $(this).on('click', function(){
                var myParent = $(this).attr('data-parent');
                console.log('myParent : ' + myParent);
                _this.showReply(myParent, false);
            })
        })
    }
    ,
    setTag1 : function(data) {
        var tag1 = (data.comDepth == 1) ? 'reviewbody-first' : 'reviewbody-second';
        var el = 
        `
        <div class="review-body-container `+tag1+` review_parent_`+data.comParent+`">

            <div class="review-body-box">
            
                <div class="review-body-list">
                    <div class="review-body-list-profile">
                        <img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
                        <div class="review-body-list-profile-box">
                            <div class="review-body-list-name">`+data.meName+`</div>
                            <div class="review-body-list-date">`+data.comEnroll+`</div>
                        </div>
                    </div>
                    <div class="review-body-list-right">
                        <button class="review-body-list-right-btn">
                            <img class="review-body-list-right-btn-img" src="/comi/resources/images/1.png">
                        </button>
                    </div>
                </div>

                <div class="review-body-read">
                    <div class="review-body-read-text">
                        `+data.comCon+`
                    </div>
                </div>

                <div class="review-body-bottom">
                    <button class="review-body-bottom-retext review_parent_`+data.comParent+`" data-parent="`+data.comParent+`" >
                        댓글 <b>`+data.comCount+`</b>
                    </button>
                    <div class="review-body-bottom-heartbox">
                        <button class="review-body-bottom-heart">
                            <img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
                        </button>
                        <span class="review-body-heart">
                            `+data.comViews+`
                        </span>
                    </div>
                </div>
            </div>
        </div>
        `;

        return el;
    },
    showReply : function(myParent, flag) {
        $('.reviewbody-second.review_parent_'+myParent).each(function(){
            if(!flag) $(this).hide();
            else $(this).show();
        });

        $('.review-rewriting.review_parent_'+myParent).each(function(){
            if(!flag) $(this).hide();
            else $(this).show();
        });
        
        $('.review-fold-btn.review_parent_'+myParent).each(function(){
            if(!flag) $(this).hide();
            else $(this).show();
        });

        $('.review-write-inner-reply.review_parent_'+myParent).each(function(){
            if(!flag) $(this).hide();
            else $(this).show();
        });
    }
}


function view_reply_write(parent, mynum){
    var parent = Number(parent);

    var el = `
    <!-- 게시글 리뷰-->
    <section id="review">
        <!--댓글 헤드-->
        <div class="review-head">
            <span class="review-head-title" id="review_number"><%= partyColistCount %>개의 댓글</span>
            <button type="button" class="review-head-refresh" alt="새로고침">
                <img src="/comi/resources/images/refresh.png">
            </button>
        </div>
        <!--댓글 헤드 end-->

        <!--댓글 쓰기-->
        <div class="review-write">
            <form action="" action="/comi/partycoins" method="post">
                <fieldset>
                <% if(login.equals("login")) { %>
                    <legend class="u_vc">댓글 쓰기</legend>
                    <div class="review-write-inner review_parent_<%= party.getPaNum() %>" data-mynum="<%= party.getPaNum() %>">
                        
                        <div class="review-write-profilearea">
                            <div class="review-write-profile">
                                <img src="/comi/resources/images/deafault.png" class="img-profile">
                                <span class="write-name"><%= myNick %></span>
                            </div>
                        </div>

                        <div class="review-write-area">
                            <div class="review-write-area-inbox">
                                <textarea name="reply" title="댓글" class="review-write-textarea" id="review_textarea_1" rows="3" cols="30" maxlength="300"></textarea>
                                <label for="review_write_textarea_1" id="review_textlabel_1" class="u_cbox_guide">
                                    다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
                                    모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
                                </label>
                            </div>
                        </div>
                        
                        <div class="review-write-count-box">
                            <div class="review-write-count">
                                <strong class="review-write-count-num" id="write_count_1">0</strong>/
                                <span class="review-write-count-total">300</span>
                            </div>
                            <input type="button" class="review-write-upload" id="party_reply_btn" value="등록">
                        </div>
                    
                    </div>
                <% }else{ %>    
                    <div class="review-write-inner review-write-inner-login">
                    	<div class="review-write-oucontainer">
                    		<textarea title="댓글" id="review-write-outtext" class="review-write-outbox" rows="3" cols="30"></textarea>
                    		<label for="review-write-outtext" class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                    	</div>
                    </div>
                <% } %>
                </fieldset>
            </form>
        </div>
        <!--댓글 쓰기 end-->
		<% 
        if(partyColistCount > 0 && partyCoList != null) { %>
        <!--댓글 정렬 버튼-->
        <div class="review-sort">
            <button class="review-sort-btn sort-type-1 active">공감순</button>
            <button class="review-sort-btn sort-type-2">최신순</button>
            <button class="review-sort-btn sort-type-3">답글순</button>
        </div>
        <!--댓글 정렬 버튼 end-->
        <% } %>
        
        <!--댓글 보기-->
        <div class="review-body">
    	<% 
        if(partyColistCount > 0 && partyCoList != null) {
            for(int i=0; i<partyCoList.size(); i++) { %>
            <div class="review-package">
        <%     	
        		ArrayList<PartyCo> tempList = partyCoList.get(i);
        		for(int j=0; j<tempList.size(); j++) {%>
        			
            		<%if(tempList.get(j).getComDepth() == 1){ //첫번째 뎁스 %>
            			<div class="review-body-container reviewbody-first review_parent_<%= tempList.get(j).getComParent() %>">
        			<% }else{ %>
        				<%if(j == 1){//두번째 뎁스 %>
        				<div class="review-reply-area area_parent_<%= tempList.get(j).getComParent() %>" data-parent="<%= tempList.get(j).getComParent() %>">
        				<%}%>
        				<div class="review-body-container reviewbody-second review_parent_<%= tempList.get(j).getComParent() %>" data-parent="<%= tempList.get(j).getComParent() %>">
        				
        			<%}//if문 1 %>
        			
        			<div class="review-body-box">
		
		                <div class="review-body-list">
		                    <div class="review-body-list-profile">
		                        <img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
		                        <div class="review-body-list-profile-box">
		                            <div class="review-body-list-name">마이프레셔스</div>
		                            <div class="review-body-list-date"><%= tempList.get(j).getComEnroll() %></div>
		                        </div>
		                    </div>
		                    <div class="review-body-list-right">
		                        <button class="review-body-list-right-btn">
		                            <img class="review-body-list-right-btn-img" src="/comi/resources/images/1.png">
		                        </button>
		                    </div>
		                </div>
		
		                <div class="review-body-read">
		                    <div class="review-body-read-text">
		                        <%= tempList.get(j).getComCon() %>
		                    </div>
		                </div>
		
		                <div class="review-body-bottom">
		                    <button class="review-body-bottom-retext review_parent_<%= tempList.get(j).getComParent() %>" data-parent="<%= tempList.get(j).getComParent() %>" >
		                        댓글 <b><%= tempList.get(j).getComCount() %></b>
		                    </button>
		                    <div class="review-body-bottom-heartbox">
		                        <button class="review-body-bottom-heart">
		                            <img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
		                        </button>
		                        <span class="review-body-heart">
		                        	<%= tempList.get(j).getComViews() %>
								</span>
		                    </div>
		                </div>
		
		            </div>
		
		        </div><!-- review-body -->
    		<%if(j!=0 && j == tempList.size()-1){ //댓글의 댓글의 마지막 %>
    			<% if(login.equals("login")) { %>
			        <!--댓글 쓰기-->
			        <div class="review-write review-rewriting review_parent_<%= tempList.get(j).getComParent() %>" data-parent="<%= tempList.get(j).getComParent() %>">
			            <form>
			                <fieldset>
			                    <legend class="u_vc">댓글 쓰기</legend>
			                    <div class="review-write-inner review_mynum_<%= tempList.get(j).getComNum() %>" data-panum="<%= tempList.get(j).getPaNum() %>" data-parent="<%= tempList.get(j).getComParent() %>" data-mynum="<%= tempList.get(j).getComNum() %>">
			                        
			                        <div class="review-write-profilearea">
			                            <div class="review-write-profile">
			                                <img src="/comi/resources/images/deafault.png" class="img-profile">
			                                <span class="write-name"><%= myNick %></span>
			                            </div>
			                        </div>
			
			                        <div class="review-write-area">
			                            <div class="review-write-area-inbox">
			                                <textarea title="댓글" class="review-write-textarea" rows="3" cols="30"></textarea>
			                                <label for="review_write_textarea_2" class="u_cbox_guide">
			                                    다양한 의견이 서로 존중될 수 있도록 다른 사람에게 불쾌감을 주는 욕설, 혐오, 비하의 표현이나 타인의 권리를 침해하는 내용은 주의해주세요.  
			                                    모든 작성자는 <em class="guide_emphasis">본인이 작성한 의견에 대해 법적 책임을 갖는다는 점</em> 유의하시기 바랍니다.
			                                </label>
			                            </div>
			                        </div>
			                        
			                        <div class="review-write-count-box">
			                            <div class="review-write-count">
			                                <strong class="review-write-count-num">0</strong>/
			                                <span class="review-write-count-total">300</span>
			                            </div>
			                            <input type="button" class="review-write-upload" value="등록">
			                        </div>
			                    
			                    </div>
			                </fieldset>
			            </form>
			        </div>
			        <!--댓글 쓰기 end--> 
			        
			        <% }else{ %>    
			        <div class="review-write-inner review-write-inner-reply review_parent_<%= tempList.get(j).getComParent() %>">
			        	<div class="review-write-oucontainer">
			        		<textarea title="댓글" id="review-write-outtext" class="review-write-outbox" rows="3" cols="30"></textarea>
			        		<label for="review-write-outtext" class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
			        	</div>
			        </div>
			        <% } %>
			        
				<button class="review-fold-btn review_parent_<%= tempList.get(j).getComParent() %>" data-parent="<%= tempList.get(j).getComParent() %>">
					<span class="review-fold-btn-text">답글 접기</span>
				</button>
    		
    		</div><!-- review-reply-area -->
    		<%}%>
        		
        	<%}//for문 1 %>
          <%}//for문 2 %>
        <%}%>
        
        </div><!--댓글 보기 end-->
		
        <div class="review-bottom">
        
        	<% 
        	copage.setEndPage(10);
        	//out.print(copage);
        	   if(copage.getCurrentPage() <= 1){ %>
            	<button class="review-bottom-btn" id="review_bottom_prev"></button>
            <% }else{ %>
	    		<button class="review-bottom-btn active" id="review_bottom_prev"></button>
	    	<% } %>
            
			<% 
			for(int p=copage.getStartPage(); p<=copage.getEndPage(); p++){ 
				if(p == copage.getCurrentPage()) {
			%>	
				<button class="review-bottom-btn active" id="review_pagebtn_"<%= p %>>
  					<span class="review-pagespan"><%= p %></span>
  				</button>
			<%	}else{ %>
				<button class="review-bottom-btn" id="review_pagebtn_"<%= p %>>
  					<span class="review-pagespan"><%= p %></span>
  				</button>
			
			<%}%>
				
			<%}//for문 %>
			
			<% if((copage.getCurrentPage() + copage.getLimit()) < copage.getEndPage() 
					&& (copage.getCurrentPage() + copage.getLimit()) > copage.getMaxPage()){ //이전그룹이 있다면 %>
	    		<button class="review-bottom-btn active" id="review_bottom_next"></button>
	    	<% }else{ %>
	    		<button class="review-bottom-btn" id="review_bottom_next"></button>
	    	<% } %>
            
        </div>
		
        <!--<button id="replyMoreBtn"><b>댓글 더보기</b></button>-->
    </section>
    <!-- 게시글 리뷰 end-->
    `;
}