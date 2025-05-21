package com.example.boardserver.service.imple;

import com.example.boardserver.dto.CategoryDTO;
import com.example.boardserver.exception.BoardServerException;
import com.example.boardserver.mapper.CategoryMapper;
import com.example.boardserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void register(String accountId, CategoryDTO categoryDTO) {
        if (accountId != null) {
            try {
                categoryMapper.register(categoryDTO);
            } catch (RuntimeException e) {
                log.error("register 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("register ERROR: {}", categoryDTO);
            throw new RuntimeException("카테코리 등록 에러" + categoryDTO);
        }
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (categoryDTO != null) {
            try {
                categoryMapper.updateCategory(categoryDTO);
            } catch (RuntimeException e) {
                log.error("update 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }else {
            log.error("update ERROR: {}", categoryDTO);
            throw new RuntimeException("카테코리 수정 에러" + categoryDTO);
        }
    }

    @Override
    public void delete(int categoryId) {
        if (categoryId != 0) {
            try {
                categoryMapper.deleteCategory(categoryId);
            } catch (RuntimeException e) {
                log.error("delete 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }else {
            log.error("delete ERROR");
            throw new RuntimeException("카테코리 삭제 에러");
        }
    }
}
