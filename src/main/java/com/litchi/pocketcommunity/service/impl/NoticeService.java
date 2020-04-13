package com.litchi.pocketcommunity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litchi.pocketcommunity.bean.Notice;
import com.litchi.pocketcommunity.bean.NoticeExample;
import com.litchi.pocketcommunity.dao.NoticeMapper;
import com.litchi.pocketcommunity.service.INoticeService;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: NoticeService
 * @Description: TODO
 * @author: litchi
 */
@Service
public class NoticeService implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
    * @description: get notices by page
    * TODO 
    * @param: pageNum, pageSize
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getNotices(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Notice> noticePageInfo = new PageInfo<>(noticeMapper.selectByExampleWithName(new NoticeExample()));
        List<Notice> notices = noticePageInfo.getList();

        int pages = noticePageInfo.getPages();
        ResultMessage resultMessage = ResultMessage.getInstance()
                .result(ResultMessage.SUCCESS_RESULT).putData("notices", notices).putData("pages", pages);
        return resultMessage;
    }

    @Override
    public ResultMessage addNotice(Notice notice) {
        noticeMapper.insert(notice);
        return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT);
    }
}
