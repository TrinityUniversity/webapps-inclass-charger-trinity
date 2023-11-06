const button = document.getElementById("inc")

button.onclick = () => {
    fetch(`/getNumber`, {
      method: 'GET',
    }).then(response => response.json()).then(data => console.log(data))

}