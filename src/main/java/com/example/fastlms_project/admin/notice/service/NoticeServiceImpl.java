package com.example.fastlms_project.admin.notice.service;

import com.example.fastlms_project.admin.notice.dto.NoticeDto;
import com.example.fastlms_project.admin.notice.model.NoticeRegister;
import com.example.fastlms_project.admin.notice.repository.NoticeRepository;
import com.example.fastlms_project.admin.notice.entity.Notice;
import com.example.fastlms_project.admin.notice.mapper.NoticeMapper;
import com.example.fastlms_project.admin.notice.model.NoticeParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    @Override
    public boolean noticeRegister(NoticeRegister parameter) {
        Optional<Notice> optionalNotice = noticeRepository.findById(parameter.getNoticeNumber());
        if(optionalNotice.isPresent()){
            return false;
        }

        Notice notice = Notice.builder()
                .noticeStatus(parameter.isNoticeStatus())
                .noticeViewCount(0)
                .noticeRegDt(LocalDateTime.now())
                .noticeTitle(parameter.getNoticeTitle())
                .noticeContents(parameter.getNoticeContents())
                .build();

        noticeRepository.save(notice);

        return true;
    }

    @Override
    public boolean noticeEdit(NoticeRegister parameter) {
        Optional<Notice> optionalNotice = noticeRepository.findById(parameter.getNoticeNumber());
        if (!optionalNotice.isPresent()){
            return false;
        }

        Notice notice = optionalNotice.get();
            notice.setNoticeTitle(parameter.getNoticeTitle());
            notice.setNoticeContents(parameter.getNoticeContents());
            notice.setNoticeStatus(parameter.isNoticeStatus());

        noticeRepository.save(notice);

        return true;
    }

    @Override
    public NoticeDto noticeGetDetail(int key) {
        return noticeRepository.findById(key).map(NoticeDto::of).orElse(null);
    }

    @Override
    public List<NoticeDto> noticeList(NoticeParam parameter) {
        long totalCount = noticeMapper.noticeCount(parameter);

        List<NoticeDto> list = noticeMapper.noticeList(parameter);
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
    public boolean noticeDelete(Integer noticeNumber) {
        Integer key = noticeNumber;

        Optional<Notice> optionalNotice = noticeRepository.findById(key);
        if (!optionalNotice.isPresent()){
            return false;
        }

        noticeRepository.deleteById(key);
        return true;
    }
}
