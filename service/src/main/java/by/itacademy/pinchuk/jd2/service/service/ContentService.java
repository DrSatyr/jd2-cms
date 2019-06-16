package by.itacademy.pinchuk.jd2.service.service;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.entity.Content;
import by.itacademy.pinchuk.jd2.database.repository.ContentRepository;
import by.itacademy.pinchuk.jd2.service.mapper.ContentMapper;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public List<ContentDto> findAll(Predicate predicate) {
        Iterable<Content> iterable = contentRepository.findAll(predicate);
        Stream<Content> stream = StreamSupport.stream(iterable.spliterator(), false);
        return stream.map(contentMapper::toContentDto).collect(Collectors.toList());
    }

    public List<ContentDto> findAllOnPage(Predicate predicate, Integer page, Integer limit) {
        PageRequest pageable = PageRequest.of(Objects.nonNull(page) && page > 1 ? page - 1 : 0, limit);
        Page<Content> find = contentRepository.findAll(predicate, pageable);
        return find.stream().map(contentMapper::toContentDto).collect(Collectors.toList());
    }

    public List<ContentDto> findAllOnPage(Integer page, Integer limit) {
        PageRequest pageable = PageRequest.of(Objects.nonNull(page) && page > 1 ? page - 1 : 0, limit);
        Page<Content> find = contentRepository.findAll(pageable);
        return find.stream().map(contentMapper::toContentDto).collect(Collectors.toList());
    }

    public Long count(Predicate predicate) {
        return contentRepository.count(predicate);
    }

    public Long count() {
        return contentRepository.count();
    }

    public int countPages(int limit) {
        long count = count();
        return pages(limit, count);
    }

    public int countPages(Predicate predicate, int limit) {
        Long count = count(predicate);
        return pages(limit, count);
    }

    private int pages(Integer limit, long count) {
        long pages = ((count / limit > 0) ? count / limit : 1) +
                ((count % limit > 0) ? 1 : 0);
        return (int) pages;
    }
}
