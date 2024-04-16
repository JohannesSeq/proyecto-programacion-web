function filterItems() {
    const filter = document.getElementById('filter').value;
    fetch(`/catalogItems?filter=${filter}`)
        .then(response => response.json())
        .then(items => displayItems(items))
        .catch(error => console.error('Error loading the catalog items:', error));
}

function displayItems(items) {
    const container = document.getElementById('catalogItems');
    container.innerHTML = ''; // Clear previous content
    items.forEach(item => {
        const div = document.createElement('div');
        div.className = 'col-md-4 mb-4';
        div.innerHTML = `
            <div class="card">
                <img src="${item.imageUrl}" class="card-img-top" alt="${item.name}">
                <div class="card-body">
                    <h5 class="card-title">${item.name}</h5>
                    <p class="card-text">${item.description}</p>
                    <p class="card-text"><small class="text-muted">${item.condition}</small></p>
                </div>
            </div>
        `;
        container.appendChild(div);
    });
}
