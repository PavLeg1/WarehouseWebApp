// Fetch data from the API endpoint
fetch('http://localhost:9090/types')
  .then(response => response.json())
  .then(data => {
    const clientTableBody = document.getElementById('typesTableBody');

    // Iterate over the data and create table rows
    data.forEach(types => {
      const row = document.createElement('tr');
      row.innerHTML = `
      <td>${types.id}</td>
      <td>${types.category}</td>
      <td>${types.base_price}</td>
      `;
      typesTableBody.appendChild(row);
    });
  })
  .catch(error => console.error(error));
