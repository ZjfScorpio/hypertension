$(document).ready(function() {
    var url = decodeURIComponent(location.href.split('#')[0]);
    console.log("url:"+url.split('/'));
    var currurl = url.split('/')[0]+'//'+url.split('/')[2];
    console.log("currul:"+currurl);
    //ajax注入权限验证
    $.ajax({
        url : "/initWXJSInterface",
        dataType : 'json',
        data : {
            'url' : url
        },
        complete : function(XMLHttpRequest, textStatus) {},
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("发生错误：" + errorThrown);
        },
        success : function(res) {

            var appId = res.appId;
            var nonceStr = res.nonceStr;
            var timestamp = res.timestamp;
            var signature = res.signature;
            wx.config({
                debug : false, //开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId : appId, //必填，公众号的唯一标识
                timestamp : timestamp, // 必填，生成签名的时间戳
                nonceStr : nonceStr, //必填，生成签名的随机串
                signature : signature, // 必填，签名，见附录1
                jsApiList : [ 'updateTimelineShareData', 'updateAppMessageShareData' ] //必填，需要使用的JS接口列表，所有JS接口列表 见附录2
            }); // end wx.config

            wx.ready(function() {
                // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
                /*
                wx.checkJsApi({
                    jsApiList : [ 'onMenuShareAppMessage' ], // 需要检测的JS接口列表，所有JS接口列表见附录2,
                    success : function(res) {
                        // 以键值对的形式返回，可用的api值true，不可用为false
                        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
                        alert(res.checkResult);
                        alert(res.errMsg);
                    }
                }); // end checkJsApi
                 */
                // alert('ready');

                wx.updateTimelineShareData({
                    title: "快来测测你患高血压的概率吧", //
                    link: currurl, //
                    imgUrl: currurl+'/img/5.png', //
                    success: function (e) {
                        //“分享到朋友圈”及“分享到QQ空间”
                    },
                    cancel: function (e) {

                    }
                });

                wx.updateAppMessageShareData({
                    title: "快来测测你患高血压的概率吧", //
                    desc:"遗传是高血压发病的一个重要原因,想知道亲人患高血压对自己影响有多大吗？", //
                    link: currurl, //
                    imgUrl: currurl+'/img/5.png', //
                    success: function (e) {
                        //自定义“分享给朋友”及“分享到QQ”按钮的分享内容
                    },
                    cancel: function (e) {

                    }
                });

            }); // end ready

            wx.error(function(res) {
                // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
                // alert('error');
            });
        } // end success
    }); // end ajax
});  // end document