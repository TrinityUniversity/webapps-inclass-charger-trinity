const button = document.getElementById("increment")
button.onclick = () => {
    fetch(`/getNumber`, {
      method: 'GET',
    }).then(response => console.log(response))

}