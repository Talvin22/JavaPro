package com.gmail.dzhaparov.homework39_1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDtoRequest(Long id, String fullName, String email, String socialSecurityNumber) {
}
