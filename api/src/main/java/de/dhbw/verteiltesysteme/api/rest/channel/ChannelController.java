package de.dhbw.verteiltesysteme.api.rest.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.verteiltesysteme.api.domain.Trending;
import de.dhbw.verteiltesysteme.shared.Region;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public ResponseEntity<Page<Trending>> get(@RequestParam(required = true) Region region,
            @RequestParam(required = true) String channelId, Pageable pageable) {
        return ResponseEntity.ok(channelService.getByRegionAndChannelId(region, channelId, pageable));
    }

}
