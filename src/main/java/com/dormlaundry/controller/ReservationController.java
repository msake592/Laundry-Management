package com.dormlaundry.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dormlaundry.model.Reservation;
import com.dormlaundry.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // -----------------------------
    // COMPLETE RESERVATION
    // -----------------------------
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Reservation> completeReservation(@PathVariable Long id) {

        Reservation completed =
                reservationService.completeReservation(id);

        return ResponseEntity.ok(completed);
    }

    // -----------------------------
    // RESCHEDULE RESERVATION
    // -----------------------------
    @PatchMapping("/{id}/reschedule")
    public ResponseEntity<Reservation> rescheduleReservation(
            @PathVariable Long id,
            @RequestBody RescheduleRequest request) {

        Reservation updated =
                reservationService.rescheduleReservation(
                        id,
                        request.getNewStartTime(),
                        request.getNewEndTime()
                );

        return ResponseEntity.ok(updated);
    }

    // -----------------------------
    // DTO (Controller-level)
    // -----------------------------
    public static class RescheduleRequest {

        private LocalDateTime newStartTime;
        private LocalDateTime newEndTime;

        public LocalDateTime getNewStartTime() {
            return newStartTime;
        }

        public void setNewStartTime(LocalDateTime newStartTime) {
            this.newStartTime = newStartTime;
        }

        public LocalDateTime getNewEndTime() {
            return newEndTime;
        }

        public void setNewEndTime(LocalDateTime newEndTime) {
            this.newEndTime = newEndTime;
        }
    }
}