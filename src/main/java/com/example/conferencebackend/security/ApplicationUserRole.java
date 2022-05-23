package com.example.conferencebackend.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.conferencebackend.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CUSTOM_USER(Sets.newHashSet(LECTURE_READ, USER_WRITE)),
    ADMIN(Sets.newHashSet(LECTURE_READ, LECTURE_WRITE, USER_READ, USER_WRITE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
