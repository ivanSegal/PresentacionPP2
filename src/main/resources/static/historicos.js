document.addEventListener("DOMContentLoaded", async () => {
    try {
        const clienteId = 123; // Reemplaza con el ID real del cliente
        const response = await fetch(`/api/compras/cliente/${clienteId}`);
        
        if (response.ok) {
            const pedidos = await response.json();
            const historialDiv = document.querySelector("#historial-pedidos");
            console.log(pedidos);

            if (pedidos.length === 0) {
                historialDiv.innerHTML = "<p>No tienes pedidos anteriores.</p>";
            } else {
                pedidos.forEach(pedido => {
                    const pedidoDiv = document.createElement("div");
                    pedidoDiv.classList.add("pedido-item");
                    pedidoDiv.innerHTML = `
                        <h3>Pedido ${pedido.id} - ${new Date(pedido.fechaCompra).toLocaleString()}</h3>
                        <ul>
                            ${pedido.detalles.map(detalle => `
                                <li>
                                    <img src="${detalle.comida.thumbnailUrl}" alt="${detalle.comida.nombre}" width="50">
                                    ${detalle.comida.nombre} - ${detalle.cantidad} unidades - $${detalle.precio}
                                    <p>${detalle.comida.descripcion}</p>
                                </li>
                            `).join("")}
                        </ul>
                        <hr />
                    `;
                    historialDiv.appendChild(pedidoDiv);
                });
            }
        } else {
            alert("Error al cargar el historial de pedidos.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al cargar el historial de pedidos.");
    }
});




//històricos

document.querySelector("#inicio-btn").addEventListener("click", () => {
	//console.log("aca historicos")
    window.location.href = "index.html";
});
