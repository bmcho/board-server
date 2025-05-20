package com.example.boardserver.service.imple;

import com.example.boardserver.dto.CategoryDTO;
import com.example.boardserver.mapper.CategoryMapper;
import com.example.boardserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void register(String accountId, CategoryDTO categoryDTO) {
        if (accountId != null) {
            categoryMapper.register(categoryDTO);
        } else {
            log.error("register ERROR: {}", categoryDTO);
            throw new RuntimeException("카테코리 등록 에러" + categoryDTO);
        }
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (categoryDTO != null) {
            categoryMapper.updateCategory(categoryDTO);
        }else {
            log.error("update ERROR: {}", categoryDTO);
            throw new RuntimeException("카테코리 수정 에러" + categoryDTO);
        }
    }

    @Override
    public void delete(int categoryID) {
        if (categoryID != 0) {
            categoryMapper.deleteCategory(categoryID);
        }else {
            log.error("delete ERROR");
            throw new RuntimeException("카테코리 삭제 에러");
        }
    }
}
