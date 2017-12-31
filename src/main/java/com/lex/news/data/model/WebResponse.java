package com.lex.news.data.model;

/**
 * 新闻类，网络响应
 * Created by lex on 2017/3/4.

 {
 "reason": "成功的返回",
 "result": {
         "stat": "1",
         "data": [
                {
                 "uniquekey": "6c4caa0c3ba6e05e2a272892af43c00e",
                 "title": "杨幂的发际线再也回不去了么？网友吐槽像半秃",
                 "date": "2017-01-05 11:03",
                 "category": "yule",
                 "author_name": "腾讯娱乐",
                 "url": "http://mini.eastday.com/mobile/170105110355287.html?qid=juheshuju",
                 "thumbnail_pic_s": "http://03.imgmini.eastday.com/mobile/20170105/20170105110355_
                 806f4ed3fe71d04fa452783d6736a02b_1_mwpm_03200403.jpeg",
                 "thumbnail_pic_s02": "http://03.imgmini.eastday.com/mobile/20170105/20170105110355_
                 806f4ed3fe71d04fa452783d6736a02b_2_mwpm_03200403.jpeg",
                 "thumbnail_pic_s03": "http://03.imgmini.eastday.com/mobile/20170105/20170105110355_
                 806f4ed3fe71d04fa452783d6736a02b_3_mwpm_03200403.jpeg"
                 },
                 ...]
            }
 }

 */

public class WebResponse {
    public String reason;
    public Result result;
    public int error_code;
}

