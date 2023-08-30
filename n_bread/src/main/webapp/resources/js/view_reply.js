var veiwArr = [];
var login = 'login';
var myMeNum = 1;

document.addEventListener("DOMContentLoaded", function(){
    
    var viewReply = new View_reply();
    viewReply.buttonEvent();
})

function View_reply(){
    
}

View_reply.prototype = {
    
    connectInsert : function(menum, panum, page, depth, parent, content){
        var _this = this;
        var url = '/comi/partycoins?menum='+menum +'&panum=' + panum + '&depth=' + depth + '&parent=' + parent + '&content=' + content + '&page' + page;
        $.ajax({
            url : url
            ,type : 'post'
            ,dataType : 'json'
            ,success : function(data){
                _this.setJson(data);
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })
    }
    ,
    connectSelect : function(menum, panum, page){
        var _this = this;
        var url = '/comi/partycosel?menum='+menum +'&panum=' + panum + '&page=' + page;
        $.ajax({
            url : url
            ,type : 'post'
            ,dataType : 'json'
            ,success : function(data){
                _this.setJson(data);
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })
    }
    ,
    connectSort : function(type, menum, panum, page){
        var _this = this;
        var url = '/comi/partycosort?type='+type+'&menum='+menum +'&panum=' + panum + '&page=' + page;
        $.ajax({
            url : url
            ,type : 'post'
            ,dataType : 'json'
            ,success : function(data){
                _this.setJson(data);
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })


        
    }
    ,
    setJson : function(){
        var str = JSON.stringify(data);
        var json = JSON.parse(str);
        console.log('str : ' + str);
        console.log('json.paging : ' + json.paging);
        console.log('json.list : ' + json.list);

        //$('#review_number').html(reviewLength + '개의 댓글');
        $('#review').empty();
        //댓글 리스트 불러오기
        
        $('#review').append(viewReplyInit(json, login));
        this.buttonEvent();
        //location.href = "#review";
    }
    ,
    buttonEvent : function(){
        
        var _this = this;

        //새로고침
        $('.review-head-refresh').on('click', function(){
            var panum = $('.review-head').attr('data-panum');
            _this.connectSelect(myMeNum, panum, currentPage);
        })

        //정렬
        $('.review-sort-btn').each(function(){
            $(this).on('click', function(){
                var id = Number($(this).attr('id').split('_').pop());
                var type = 'current';
                if(id == 2) type = 'interest';
                else if(id == 2) type = 'count';
                _this.connectSort(type, myMeNum, panum, currentPage);
            })
        })

        //로그인 페이지
        $('.review-write-oucontainer').each(function(){
            if(login == 'login'){
                $(this).find('.review-write-guide').text('댓글을 작성하려면 클릭하세요.');
            }else{
                $(this).find('.review-write-guide').text('댓글을 작성하려면 로그인하세요.');
            }

            $(this).on('click', function(){
                if(login == 'login'){
                    //$(this).hide();
                    
                    $(this).parent().parent().find('.review-write-inner-reply').hide();
                    $(this).parent().parent().find('.review-write-inner-login').hide();
                    $(this).parent().parent().find('.review-rewriting').show();
                }else{
                    if(confirm('로그인을 하신 후 이용해 주시기 바랍니다.')) {
                        //로그인 페이지로 이동
                        //location.href = '/comi/main.jsp';
                    }else{
                        
                    }
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
                    var depth = 1;
                    var parent = -1;
                    var panum;
                    var package;
                    if($(this).attr('id') == 'party_reply_btn') {
                        //파티 바로 댓글 뎁스 1
                        depth = 1;
                        package = $(this).parent().parent('.review-write-inner');
                        panum = package.attr('data-panum');
                        console.log('class = ' + package.attr('class'));
                    }else{
                        depth = 2;
                        package = $(this).parent().parent().parent().parent().parent().parent().parent('.review-package');
                        parent = package.find('.review-body-container').attr('data-parent');
                        panum = package.find('.review-body-container').attr('data-panum');
                    }
                    
                    var textarea = package.find('.review-write-textarea');
                    var writeName = package.find('.write-name');
                    
                    /*
                    var data = {
                        comDepth : depth//1일때는 파티의 댓글 2일때는 댓글의 댓글
                        ,paNum : panum
                        ,comParent : comparent
                        ,comCon : textarea.val()
                        ,comCount : 0
                        ,comViews : 0
                        ,comEnroll : ''
                        ,meName : writeName.text()
                        ,menum : menum
                        //,member : member
                    }
                    veiwArr.push(data);
                    */
                    console.log('댓글 달기 depth : ' + depth + ' panum : ' + panum + ' parent : ' + parent + ' content : ' + textarea.val());
                    _this.connectInsert(myMeNum, panum, currentPage, depth, parent, textarea.val());
                    
                }
                return false;
            });
        })
        
        //댓글보기
        $('.review-body-bottom-retext').each(function(){
            $(this).on('click', function(){
                var reviewbody = $(this).parent().parent().parent('.review-body-container');
                var parent = reviewbody.attr('data-parent');
                var package = $(this).parent().parent().parent().parent('.review-package');
                
                console.log('parent : ' + parent);
                var visible = package.find('.review-reply-area').css('display');
                console.log('visible : ' + visible);
                _this.showReply(package, visible);
                
            })
        })

        //댓글 접기
        $('.review-fold-btn').each(function(){
            $(this).on('click', function(){
                var package = $(this).parent().parent('.review-package');
                var parent = package.find('.review-body-container').attr('data-parent');
                console.log('parent : ' + parent);
                var visible = package.find('.review-reply-area').css('display');
                console.log('visible : ' + visible);
                _this.showReply(package, visible);
            })
        })

        //네비 버튼
        $('.review-bottom-btn').each(function(){
            $(this).on('click', function(){
                var arr = $(this).attr('id').split('_')
                var name = arr[0];
                var id;
                var page = currentPage;

                if(name == 'reviewPagebtn') {
                    id = Number(arr[1]);
                    page = id;
                }else{
                    id = arr[1];
                    //백넥스트
                    //if($(this).attr('class') == 'disabled')
                    if(id == 'next'){
                        page ++;
                    }else{
                        page --;
                    }
                }
                var panum = $('.review-head').attr('data-panum');
                _this.connectSelect(myMeNum, panum, page);
                
            })
        })

        //하트 클릭 
        $('.review-body-bottom-heart').each(function(){
            $(this).on('click', function(){
                var heart = $(this).attr('data-heart');
                var heartNum = Number($(this).parent().find('.review-body-heart').text());
                
                if(heart == 'empty') {
                    console.log('>> heartNum 1 : ' + heartNum);
                    heartNum ++;
                    $(this).attr('data-heart', heartNum);
                    console.log('>> heartNum 2 : ' + heartNum);
                }else{
                    heartNum --;
                    $(this).attr('data-heart', 'empty');
                }

                $(this).parent().find('.review-body-heart').text(heartNum);
            })
            
        })

        //삭제 버튼 클릭
        $('.review-body-list-right-btn').each(function(){
            $(this).on('click', function(){

            })
        })
        
    },
    showReply : function(package, visible) {
        if(visible == 'block') {
            package.find('.review-reply-area').hide();
            package.find('.review-rewriting').hide();
        }else {
            package.find('.review-reply-area').show();
            package.find('.review-write-inner-reply').show();
        }
    }
    
}

function decode (str) {
    var str2 = decodeURIComponent(str);
    return str2.replace(/\+/g, ' ');
}

//태그 붙이기
function viewReplyInit(data){
    //var parent = Number(parent);
    console.log('data : ', JSON.stringify(data));
    var myNick = '??';
    
    console.log('login : ' + login);
    var el = `
    <!--댓글 헤드-->
        <div class="review-head" data-panum="` + data.list[0][0].paNum + `">
            <span class="review-head-title" id="review_number">`+data.listCount+`개의 댓글</span>
            <button type="button" class="review-head-refresh" alt="새로고침">
                <img src="/comi/resources/images/refresh.png">
            </button>
        </div>
        <!--댓글 헤드 end-->

        <!--댓글 쓰기-->
        <div class="review-write">
            <form action="" action="/comi/partycoins" method="post">
                <fieldset>`

                if(login == 'login') {
                    el += `
                    <legend class="u_vc">댓글 쓰기</legend>
                    <div class="review-write-inner review-rewriting" 
            			data-panum="` + data.list[0][0].paNum + `">
                        
                        <div class="review-write-profilearea">
                            <div class="review-write-profile">
                                <img src="/comi/resources/images/deafault.png" class="img-profile">
                                <span class="write-name">` + myNick + `</span>
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
                    
                    </div>`
                }else{ 
                    
                }
                el += `
                    <div class="review-write-inner review-write-inner-login">
                    	<div class="review-write-oucontainer">
                    		<textarea title="댓글" class="review-write-outbox" rows="3" cols="30" readonly></textarea>
                    		<label class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                    	</div>
                    </div>
                </fieldset>
            </form>
        </div>
        <!--댓글 쓰기 end-->`
		
        if(data.listCount > 0 && (data.list != null && data.list != undefined)) {
        el += `
        <!--댓글 정렬 버튼-->
        <div class="review-sort">
            <button class="review-sort-btn active" id="sortType_1">공감순</button>
            <button class="review-sort-btn" id="sortType_2">최신순</button>
            <button class="review-sort-btn" id="sortType_3">답글순</button>
        </div>
        <!--댓글 정렬 버튼 end-->`
        }
        
        el += `
        <!--review-body-->
        <div class="review-body">`
    	
        if(data.listCount > 0 && (data.list != null && data.list != undefined)) {
            for(var i=0; i<data.list.length; i++) { 
            	var depth1Obj =data.list[i][0];

            el += `
            <div class="review-package">
            	
            	<div class="review-body-container reviewbody-first" 
            	data-parent="` + depth1Obj.comParent + `" 
            	data-depth="` + depth1Obj.comDepth + `"
            	data-panum="` + depth1Obj.paNum + `">
            	
	            	<!-- review-body-box -->
	       			<div class="review-body-box">
		
		                <div class="review-body-list">
		                    <div class="review-body-list-profile">
		                        <img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
		                        <div class="review-body-list-profile-box">
		                            <div class="review-body-list-name">` + decode(depth1Obj.meAka) + `</div>
		                            <div class="review-body-list-date">`+ depth1Obj.comEnroll +`</div>
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
                                `+ depth1Obj.comCon +`
		                    </div>
		                </div>
		
		                <div class="review-body-bottom">
		                    <button class="review-body-bottom-retext">
		                        댓글 <b>`+ depth1Obj.comCount +`</b>
		                    </button>
		                    <div class="review-body-bottom-heartbox">
		                        <button class="review-body-bottom-heart" data-heart="empty">
		                            <img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
		                        </button>
		                        <span class="review-body-heart">
                                    `+ depth1Obj.comViews +`
								</span>
		                    </div>
		                </div>
		
		            </div>
	       			<!-- review-body-box end -->
            	</div>
            	
            	<div class="review-reply-area">`
            		
	            	 
	            	var tempList = data.list[i];
	            	
	            	if(tempList.length == 1) {
    					if(login == "login") {
                            el +=`
        					<!--댓글 쓰기-->
					        <div class="review-write review-rewriting">
					            <form>
					                <fieldset>
					                    <legend class="u_vc">댓글 쓰기</legend>
					                    <div class="review-write-inner review-rewriting">
					                        
					                        <div class="review-write-profilearea">
					                            <div class="review-write-profile">
					                                <img src="/comi/resources/images/deafault.png" class="img-profile">
					                                <span class="write-name">`+ myNick + `</span>
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
                            
    					}
                            el += `
                            <div class="review-write-inner review-write-inner-reply">
                                <div class="review-write-oucontainer">
                                    <textarea title="댓글" class="review-write-outbox" rows="3" cols="30" readonly></textarea>
                                    <label class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                                </div>
                            </div>
    						<button class="review-fold-btn">
								<span class="review-fold-btn-text">답글 접기</span>
							</button>`
    				}else {
	            	
		            	for(var j=1; j<tempList.length; j++) {
                            el += `
		            		<div class="review-body-container reviewbody-second" data-parent="`+ tempList[j].comParent + `">
		        			
			        			<!-- review-body-box -->
			        			<div class="review-body-box">
					
					                <div class="review-body-list">
					                    <div class="review-body-list-profile">
					                        <img class="review-body-list-profile-img" src="/comi/resources/images/profile.png">
					                        <div class="review-body-list-profile-box">
					                            <div class="review-body-list-name">` + decode(tempList[j].meAka) + `</div>
					                            <div class="review-body-list-date">` + tempList[j].comEnroll + `</div>
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
					                        `+ tempList[j].comCon +`
					                    </div>
					                </div>
					
					                <div class="review-body-bottom">
					                    <button class="review-body-bottom-retext">
					                        댓글 <b>` + tempList[j].comCount + `</b>
					                    </button>
					                    <div class="review-body-bottom-heartbox">
					                        <button class="review-body-bottom-heart" data-heart="empty">
					                            <img class="review-body-bottom-heart-img" src="/comi/resources/images/heart.png">
					                        </button>
					                        <span class="review-body-heart">
					                        	` + tempList[j].comViews +`
											</span>
					                    </div>
					                </div>
					
					            </div>
					            <!-- review-body-box end -->
					        </div>
			        		<!-- review-body-container reviewbody-second end -->`
		        			
		       				if(j == tempList.length-1) { 
		       					if(login == "login") { 
                                    el += `
		        					<!--댓글 쓰기-->
							        <div class="review-write review-rewriting">
							            <form>
							                <fieldset>
							                    <legend class="u_vc">댓글 쓰기</legend>
							                    <div class="review-write-inner review-rewriting">
							                        
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
							        <!--댓글 쓰기 end-->`
		       					}else{
                                    
		       					}
                                   el += `
                                   <div class="review-write-inner review-write-inner-reply">
                                       <div class="review-write-oucontainer">
                                           <textarea title="댓글" class="review-write-outbox" rows="3" cols="30" readonly></textarea>
                                           <label class="review-write-guide" >댓글을 작성하려면 로그인 해주세요</label>
                                       </div>
                                   </div>
                                    <button class="review-fold-btn">
                                        <span class="review-fold-btn-text">답글 접기</span>
                                    </button>`
		       				}
		              	}
              		}
              	el += `
              	</div><!-- review-reply-area end -->
              	
            </div>
            <!--review-package end-->`
            }
        }  	
        el += `
        </div>
		<!--review-body end-->

        <!-- review-bottom -->
		<div class="review-bottom">`
        
        var copage = data.paging;
        if(copage.currentPage <= 1){ 
            //el += `<button class="review-bottom-btn" id="review_bottom_prev"></button>`;
        }else{ 
            //el += `<button class="review-bottom-btn active" id="review_bottom_prev"></button>`
        } 
        
            
        for(var p=copage.startPage; p<=copage.endPage; p++){ 
            if(p == copage.currentPage) {
                el += `
                <button class="review-bottom-btn active" id="reviewPagebtn_` + p + `">
                    <span class="review-pagespan">` + p + `</span>
                </button>`
            }else{
                el += `
                <button class="review-bottom-btn" id="reviewPagebtn_` + p + `">
                    <span class="review-pagespan">` + p + `</span>
                </button>`
            } 
        }
        
        if((copage.currentPage + copage.limit) < copage.endPage 
                && (copage.currentPage + copage.limit) > copage.maxPage){ 
            //el += `<button class="review-bottom-btn active" id="review_bottom_next"></button>`;
        }else{
            //el += `<button class="review-bottom-btn" id="review_bottom_next"></button>`;
        }
        el += `
        </div>
        <!-- review-bottom end -->
    `

    return el;
}