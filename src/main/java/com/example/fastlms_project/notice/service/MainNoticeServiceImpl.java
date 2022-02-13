package com.example.fastlms_project.notice.service;

import com.example.fastlms_project.notice.dto.NoticeDto;
import com.example.fastlms_project.notice.entity.Notice;
import com.example.fastlms_project.notice.mapper.NoticeMapper;
import com.example.fastlms_project.notice.model.NoticeParam;
import com.example.fastlms_project.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainNoticeServiceImpl implements MainNoticeService {

    private final NoticeMapper noticeMapper;
    private final NoticeRepository noticeRepository;

    @Override
    public List<NoticeDto> mainNoticeList(NoticeParam parameter) {
        long totalCount = noticeMapper.mainNoticeCount(parameter);

        List<NoticeDto> list = noticeMapper.mainNoticeList(parameter);
        if (!CollectionUtils.isEmpty(list)){
            int i = 0;
            for (NoticeDto x : list){
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public NoticeDto mainNoticeDetail(int key) {
        Optional<Notice> optionalNotice = noticeRepository.findById(key);

        Notice notice = optionalNotice.get();
            int vCount = notice.getNoticeViewCount();
            notice.setNoticeViewCount((vCount+1));
        noticeRepository.save(notice);

        return noticeRepository.findById(key).map(NoticeDto::of).orElse(null);
    }
}
