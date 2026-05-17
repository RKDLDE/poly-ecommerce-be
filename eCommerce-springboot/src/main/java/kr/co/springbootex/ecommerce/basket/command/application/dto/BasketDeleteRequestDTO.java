package kr.co.springbootex.ecommerce.basket.command.application.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDeleteRequestDTO {
    private List<Long> itemIds;    // 선택 삭제할 품목 ID 리스트
}
