package by.itacademy.pinchuk.jd2.service.service;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.entity.Content;
import by.itacademy.pinchuk.jd2.database.repository.ContentRepository;
import by.itacademy.pinchuk.jd2.service.mapper.ContentMapper;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContentService {

    private ContentRepository contentRepository;
    private ContentMapper contentMapper;

    public Optional<ContentDto> findById(Long id) {
        Optional<Content> content = contentRepository.findById(id);
        ContentDto contentDto = content.map(contentMapper::toContentDto).orElse(null);
        return Optional.ofNullable(contentDto);
    }

    public List<ContentDto> findAll() {
        Iterable<Content> iterable = contentRepository.findAll();
        Stream<Content> stream = StreamSupport.stream(iterable.spliterator(), false);
        return stream.map(contentMapper::toContentDto).collect(Collectors.toList());
    }

    public List<ContentDto> findAll(Predicate predicate, Pageable pageable) {
        Page<Content> page = contentRepository.findAll(predicate, pageable);
        return page.stream().map(contentMapper::toContentDto).collect(Collectors.toList());
    }
}
