function iniciarMap(){
    var coord = {lat:-11.972117 , lng:-77.074692 };
    var map = new google.maps.Map(document.getElementById('map'),{
        zoom: 10,
        center: coord
    });
    var marker= new google.maps.marker({
        position: coord,
        map: map
    })
}