package com.litchi.pocketcommunity.service;

import com.litchi.pocketcommunity.bean.Notice;
import com.litchi.pocketcommunity.util.ResultMessage;

public interface INoticeService {
    ResultMessage getNotices(int pageNum, int pageSize);

    ResultMessage addNotice(Notice notice);
}
