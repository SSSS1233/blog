/**
 * Created by Administrator on 2018/4/13.
 */
function select(id) {
  //  alert(id)
    var id={id:id}
    $.ajax({
        url:"classification.do",
        type:"post",
        data:id,
        dataType:"json",
        success:function (data) {


            // alert(data.articles[1].id)
            var str="";
            for(var i=0;i<data.length;i++)
            {
                str+="<div class='jumbotron'> <h3>"+data.articles[i].title+
                    "</h3><span class='summary'>"+data.articles[i].summary+"</span><br><br>"+
                    "<p><a class='btn btn-primary btn-lg' href='detail.do?id="+data.articles[i].id+
                    "'role='button'> 阅读全文</a></p></div>"
            }
            //  alert(str)
            $("#container").html(str)
        }
    })
}
function selects() {
    //alert($("#title").val())
    var title={title:$("#title").val()}
    $.ajax({
        url:"selectlike.do",
        type:"post",
        data:title,
        dataType:"json",
        success:function (data) {


            // alert(data.articles[1].id)
            var str="";
            for(var i=0;i<data.length;i++)
            {
                str+="<div class='jumbotron'> <h3>"+data.articles[i].title+
                    "</h3><span class='summary'>"+data.articles[i].summary+"</span><br><br>"+
                    "<p><a class='btn btn-primary btn-lg' href='detail.do?id="+data.articles[i].id+
                    "'role='button'> 阅读全文</a></p></div>"
            }
            //  alert(str)
            $("#container").html(str)
        }
    })
}
