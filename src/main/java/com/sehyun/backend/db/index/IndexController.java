package com.sehyun.backend.db.index;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/db/index")
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/members/{memberId}")
    public Member findById(
            @PathVariable Long memberId
    ) {
        return indexService.findById(memberId);
    }

    @GetMapping("/members")
    public List<Member> findByStatus(
            @RequestParam String status
    ) {
        return indexService.findByStatus(status);
    }

    @GetMapping("/members/status-age")
    public List<Member> findByStatusAndAge(
            @RequestParam String status,
            @RequestParam Integer age
    ) {
        return indexService.findByStatusAndAge(status, age);
    }

    @GetMapping("/members/created")
    public List<Member> findByMemberAndCreatedAt(
            @RequestParam Long memberId,
            @RequestParam LocalDateTime createdAt
    ) {
        return indexService.findByMemberAndCreatedAt(
                memberId,
                createdAt
        );
    }
}