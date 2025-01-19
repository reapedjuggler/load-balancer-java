package com.userprofile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.aerospike.mapping.Document;

@Data
@Document(collection = "user_profiles")
public class UserProfile {
    @Id
    private String id;
    private String name;
    private String email;
}