package com.userprofile.repository;

import com.userprofile.model.UserProfile;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface UserProfileRepository extends AerospikeRepository<UserProfile, String> {
}