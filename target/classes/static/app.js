function createReservation() {
    fetch("/reservations", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            machineId: document.getElementById("machineId").value,
            startTime: document.getElementById("startTime").value,
            endTime: document.getElementById("endTime").value
        })
    })
    .then(res => {
        if (res.status === 201) {
            return res.json().then(data => {
                document.getElementById("createResult").innerText =
                    "Reservation created. ID: " + data.id;
            });
        }
        handleError(res, "createResult");
    });
}

function deleteReservation() {
    const id = document.getElementById("deleteId").value;

    fetch(`/reservations/${id}`, {
        method: "DELETE"
    })
    .then(res => {
        if (res.status === 204) {
            document.getElementById("deleteResult").innerText =
                "Reservation deleted";
            return;
        }
        handleError(res, "deleteResult");
    });
}

function rescheduleReservation() {
    const id = document.getElementById("rescheduleId").value;

    fetch(`/reservations/${id}/reschedule`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            newStartTime: document.getElementById("newStartTime").value,
            newEndTime: document.getElementById("newEndTime").value
        })
    })
    .then(res => {
        if (res.status === 200) {
            return res.json().then(data => {
                document.getElementById("rescheduleResult").innerText =
                    "Rescheduled successfully";
            });
        }
        handleError(res, "rescheduleResult");
    });
}

function handleError(response, elementId) {
    if (response.status === 400)
        document.getElementById(elementId).innerText = "Bad request";
    else if (response.status === 404)
        document.getElementById(elementId).innerText = "Not found";
    else if (response.status === 409)
        document.getElementById(elementId).innerText = "Time slot conflict";
    else
        document.getElementById(elementId).innerText = "Unexpected error";
}