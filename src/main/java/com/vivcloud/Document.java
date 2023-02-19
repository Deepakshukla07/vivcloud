package com.vivcloud;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="documents")
public class Document {

    /*
     * Using spring boot annotation
     * Create  field in Document class and
     * also mention primary key to id
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // specify some more property of this field
    @Column(length=512,nullable = false,unique = true)
    private String name;

    private long size;
    @Column(name="upload_time")
    private Date uploadeTime;

    private byte[] content;


//    public Document(Long id, String name, long size) {
//        this.id = id;
//        this.name = name;
//        this.size = size;
//    }

//    public Document() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getUploadeTime() {
        return uploadeTime;
    }

    public void setUploadeTime(Date uploadeTime) {
        this.uploadeTime = uploadeTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
