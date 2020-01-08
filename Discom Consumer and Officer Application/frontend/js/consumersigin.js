function valid() {
    var meter = document.getElementById("meter")
    var password = document.getElementById("password")
    if (meter.value.trim().length < 10) {
        alert("enter valid meter number")

    }
    else if (password.value.trim().length < 6) {
        alert("password minimum contains 6 characters")
    }
}