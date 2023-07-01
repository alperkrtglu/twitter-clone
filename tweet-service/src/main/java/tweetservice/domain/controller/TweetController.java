package tweetservice.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tweetservice.domain.dto.TweetAddUpdateRequestDTO;
import tweetservice.domain.dto.TweetViewResponseDTO;
import tweetservice.domain.dto.mapper.TweetMapper;
import tweetservice.domain.entity.Tweet;
import tweetservice.domain.service.TweetService;
import tweetservice.security.SessionInformationProvider;

import java.util.List;

@RestController
@RequestMapping("tweets")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USER')")
public class TweetController {

    private final SessionInformationProvider sessionInformationProvider;
    private final TweetService tweetService;

    @GetMapping
    public List<TweetViewResponseDTO> retrieve() {
        List<Tweet> tweets = tweetService.retrieve(
                sessionInformationProvider.getCurrentUserId()
        );

        return TweetMapper.entitiesToDTOs(tweets);
    }

    @PostMapping
    public void add(@RequestBody TweetAddUpdateRequestDTO dto) {
        tweetService.add(
                TweetMapper.dtoToEntity(dto, sessionInformationProvider.getCurrentUserId())
        );
    }

    @PutMapping("{id}")
    public void update(@RequestBody TweetAddUpdateRequestDTO dto, @PathVariable Long id) {
        tweetService.update(
                id, TweetMapper.dtoToEntity(dto, sessionInformationProvider.getCurrentUserId())
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        tweetService.delete(id);
    }
}
