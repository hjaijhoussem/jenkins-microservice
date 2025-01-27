package com.horizon.carpooling.dto.review;

import com.horizon.carpooling.dto.user.UserListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListDto {
        private Long id;
        private float Stars;
        private String comment;
        private UserListDto reviewer;
    }

