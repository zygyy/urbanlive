//解析显示分页信息
function build_page_info(result) {
    //清空数据
    $("#page_info_area").empty();
    $("#page_info_area").append("当前第" + result.data.pageNum + "页,总共"
        + result.data.pages + "页,共计"
        + result.data.total + "条记录");
    totalRecord = result.data.total;
    currentPage = result.data.pageNum;
}

// 解析并显示分页条信息
function build_page_nav(result) {
    //清空数据
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    //构建元素
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("上一页"));
    if (result.data.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }else {
        //为元素添加点击翻页事件
        firstPageLi.click(function () {
            searchInfo(1);
        });
        prePageLi.click(function () {
            searchInfo(result.data.pageNum-1);
        });
    }
    var nextPageLi = $("<li></li>").append($("<a></a>").append("下一页"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
    if (result.data.hasNextPage == false) {
        nextPageLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    }else {
        //为元素添加点击翻页事件
        nextPageLi.click(function () {
            searchInfo(result.data.pageNum+1);
        });
        lastPageLi.click(function () {
            searchInfo(result.data.pages);
        });
    }
    //构造首页和前一页提示按钮
    ul.append(firstPageLi).append(prePageLi);
    $.each(result.data.navigatepageNums,function (index,item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.data.pageNum == item) {
            numLi.addClass("active");
        }
        numLi.click(function () {
            searchInfo(item);
        });
        ul.append(numLi);
    });
    ul.append(nextPageLi).append(lastPageLi);
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_nav_area");
}
