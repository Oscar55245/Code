from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas

# Nombre del archivo PDF que deseas crear
pdf_file_name = "pedido.pdf"

# Código del pedido y fecha de hoy (sustituye estos valores con los tuyos)
codigo = "ABC123"
fecha_hoy = "14 de abril de 2024"
fecha_llegada = "24 de abril de 2024"

# Crear un lienzo con el tamaño de página letter (8.5x11 pulgadas)
c = canvas.Canvas(pdf_file_name, pagesize=letter)

# Tamaño y posición de la barra
barra_x = 50
barra_y = 690
barra_ancho = 500
barra_alto = 1600

# Título de la barra
titulo = "Información del Pedido"

# Agregar la barra con el título
c.setFillColorRGB(0.2, 0.4, 0.6)

c.rect(barra_x, barra_y, barra_ancho, barra_alto, fill=1)  # Dibujar la barra
c.setFillColorRGB(1, 1, 1)  # Color del texto (blanco)
c.setFont("Helvetica-Bold", 16)  # Fuente y tamaño del texto
c.drawString(barra_x + 10, barra_y + 20, titulo)  # Posicionar y agregar el título

c.drawImage("shiva.png", 350, 695, width=90, height=90)

# Información del pedido
info_pedido = f"Código del pedido: {codigo}"
c.setFont("Helvetica", 12)  # Cambiar a una fuente más pequeña
c.setFillColorRGB(0, 0, 0)  # Color de la barra (en este caso, negro)
c.drawString(100, 600, info_pedido)  # Posicionar y agregar la información del pedido
#fecha de hoy
c.setFont("Helvetica", 12)  
c.setFillColorRGB(0, 0, 0)  
c.drawString(100, 580, f"Tu pedido fue enviado el día {fecha_hoy}")  
#fecha de llegada
c.setFont("Helvetica", 12)  
c.setFillColorRGB(0, 0, 0)  
c.drawString(100, 560, f"Llegada aproximada de tu pedido {fecha_llegada}")
# Guardar el PDF
c.save()

print(f"PDF del pedido generado: {pdf_file_name}")
