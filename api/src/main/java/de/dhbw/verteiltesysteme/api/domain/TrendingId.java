package de.dhbw.verteiltesysteme.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import de.dhbw.verteiltesysteme.shared.Region;
import lombok.Data;

@Embeddable
@Data
public class TrendingId implements Serializable {

    private static final long serialVersionUID = 7737788307878484667L;

    private String videoId;
    private LocalDateTime fetchedOn;
    private Region region;

}
