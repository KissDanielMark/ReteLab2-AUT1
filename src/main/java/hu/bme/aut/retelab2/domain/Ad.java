package hu.bme.aut.retelab2.domain;


import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Ad {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Integer price;
    @CreationTimestamp
    private Date creationDate;

    private String code;
    //private String tags;
    @ElementCollection
    private List<String> tags = new ArrayList<>();

    private LocalDateTime endDateTime;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    /*
    public String getTags() {
        return tags;
    }
    public void setTag(String newTag) {
        this.tags = newTag;
    }*/

    public List<String> getTags() {
        return tags;
    }
    public void setTag(String newTag) {
        this.tags.add(newTag);
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
