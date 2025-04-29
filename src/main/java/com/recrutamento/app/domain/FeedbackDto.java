package com.recrutamento.app.domain;

public record FeedbackDto(Long idVaga, String feedback, String novoStatus, Long idUser) {}