$(document).ready(function() {

    $("#airportTable").DataTable({
        columns: [
            { "data": "location" },
            { "data": "name" },
            { "data": "registerPlaneCount" },
            {
                data: null,
                render: function (data, type, row) {
                    return '<button type="button" data-toggle="modal" data-target="#editAirportModal">Edit</button>' +
                    '<button type="button" data-toggle="modal" data-target="#deleteAirportModal">Delete</button>';
                }
            }
        ]
    });
    getData();
} );


// getdata
function getData() {
    // Get the data from endpoint.
    $.ajax({
        url: "http://localhost:8080/airport/",
        type: "get",
        success: function (airport) {
            // On successful get, reload the datatable with new data.
            $('#airportTable').DataTable().clear();
            $('#airportTable').DataTable().rows.add(airport);
            $('#airportTable').DataTable().columns.adjust().draw();
        }
    });
}


$("#newAirportForm").on('submit', function (e) {

     // Get values from html.
    let companyName = $("#id").val();
    let email = $("#name").val();

    // Create JS object with data.
    let newAirport = {
        id: id,
        name: name,
    }

    // Convert JS object to JSON.
    let validJsonSupplier = JSON.stringify(newAirport);

    // Post JSON to endpoint.
    $.ajax({
        url: "http://localhost:8080/airport/",
        type: "post",
        data: validJsonSupplier,
        contentType: "application/json",
        success: function (result) {
            // On successful post, reload data to get the added one as well.
            getData();
        }
    });

    // Reset form
    $("#id").val("");
    $("#name").val("");
});