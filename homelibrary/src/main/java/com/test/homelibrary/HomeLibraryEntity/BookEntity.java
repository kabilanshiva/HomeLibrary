package com.test.homelibrary.HomeLibraryEntity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String language;
    @Column(name = "in_the_shelf")
    private boolean inTheShelf = true;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private SlotEntity slot;

    public SlotEntity getSlot() {
        return slot;
    }

    public void setSlot(SlotEntity slot) {
        this.slot = slot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isInTheShelf() {
        return inTheShelf;
    }

    public void setInTheShelf(boolean inTheShelf) {
        this.inTheShelf = inTheShelf;
    }

}
