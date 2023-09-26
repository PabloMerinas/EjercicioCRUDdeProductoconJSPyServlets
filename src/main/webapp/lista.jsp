<%@ page import="bdController.BdController"%>
<%@ page import="model.Producto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista productos</title>
</head>
<body>

	<style>
.Slide1691 {
	width: 1920px;
	height: 1080px;
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	background: white;
}

.Slide1691 div {
	display: flex;
	justify-content: center;
	align-items: center;
}

.list {
	width: 796px;
	height: 420px;
	left: 561px;
	top: 250px;
	position: absolute;
	background: #FFFFFF;
	padding: 20px;
	border: 1px solid #D9D9D9;
	text-align: left; /* Alinea el texto a la izquierda */
}
</style>

	<div class="Slide1691"
		style="width: 1920px; height: 1080px; position: relative; background: white">
		<div class="Rectangle1"
			style="width: 1010px; height: 1080px; left: 455px; top: 0px; position: absolute; background: #D9D9D9"></div>
		<a href="index.html">
			<div class="Rectangle4"
				style="width: 839px; height: 67px; left: 561px; top: 141px; position: absolute; background: white"></div>
		</a>
		<div class="Rectangle7"
			style="width: 839px; height: 67px; left: 561px; top: 739px; position: absolute; background: white"></div>
		<a href="index.html">
			<div class="GestiNDeClientes"
				style="left: 773px; top: 145px; position: absolute; color: black; font-size: 48px; font-family: Inter; font-weight: 400; word-wrap: break-word">Gesti�n
				de productos</div>
		</a>
		<div class="PabloMerinasSoto"
			style="width: 839px; height: 67px; left: 561px; top: 739px; position: absolute; background: white; color: black; font-size: 48px; font-family: Inter; font-weight: 400; word-wrap: break-word">Pablo
			Merinas Soto</div>


		<div class="list">
			<%
			List<Producto> productList = BdController.getProductList();
			if (productList.isEmpty()) {
			%>
			<p>No hay productos disponibles.</p>
			<%
			} else {
			%>
			<table border="1" width="100%" height="100%">
				<tr>
					<th><center>Nombre</center></th>
					<th><center>Descripcion</center></th>
					<th><center>Peso</center></th>
					<th><center>Stock</center></th>
				</tr>
				<%
				for (Producto producto : productList) {
				%>
				<tr>
					<td><%=producto.getNombre()%></td>
					<td><%=producto.getDescripcion()%></td>
					<td><%=producto.getPeso()%></td>
					<td><%=producto.getStock()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<%
			}
			%>
		</div>

	</div>

</body>
</html>
