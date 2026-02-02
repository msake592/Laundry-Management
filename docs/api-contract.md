# Reservation API Contract

## Create Reservation
POST /reservations

Request Body:
{
  "machineId": number,
  "startTime": "YYYY-MM-DDTHH:mm",
  "endTime": "YYYY-MM-DDTHH:mm"
}

Responses:
- 201 Created
- 400 Bad Request (invalid time range)
- 404 Not Found (machine not found)
- 409 Conflict (time slot unavailable)

---

## Delete Reservation
DELETE /reservations/{id}

Responses:
- 204 No Content
- 404 Not Found

---

## Reschedule Reservation
PATCH /reservations/{id}/reschedule

Request Body:
{
  "newStartTime": "YYYY-MM-DDTHH:mm",
  "newEndTime": "YYYY-MM-DDTHH:mm"
}

Responses:
- 200 OK
- 400 Bad Request
- 404 Not Found
- 409 Conflict

---

## Complete Reservation
PATCH /reservations/{id}/complete

Responses:
- 200 OK
- 404 Not Found