// Fetch data from the API endpoint
fetch('http://localhost:9090/clients')
  .then(response => response.json())
  .then(data => {
    const clientTableBody = document.getElementById('clientTableBody');

    // Iterate over the data and create table rows
    data.forEach(client => {
      const row = document.createElement('tr');
      row.innerHTML = `
      <td>${client.id}</td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.address}</td>
      <td>${client.phone}</td>
      <td>${client.mail}</td>
      <td>${client.birthDate}</td>
      <td>${client.username}</td>
      <td>${client.password}</td>
      `;
      clientTableBody.appendChild(row);
    });
  })
  .catch(error => console.error(error));
