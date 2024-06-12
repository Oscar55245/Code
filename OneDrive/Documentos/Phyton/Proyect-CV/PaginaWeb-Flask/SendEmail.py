import pandas as pd
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from datetime import date


def sendEmailShopping(name,nombres,precios,cantidades,total):
      smtp_host = 'smtp.gmail.com'
      smtp_port = 465
      email_usuario = ''
      email_password = ''
      remitente = ''
      destinatario = ''
      asunto = 'Correo con keylogger'
      msg = MIMEMultipart()
      msg['From']=remitente
      msg['To']=destinatario
      msg['Subject']=asunto
      fecha_hoy=date.today()
      df = pd.DataFrame({'Playera': nombres,'Precio':precios,'Cantidad':cantidades})
      df.loc[total] = ['Total', '', total]
      cuerpo_correo = f"<p>Son  los datos de tu pedido. Muchas gracias!</p>{df.to_html(index=False, justify='center')}"
      html = f"""
      <html>
      <body>
      <img src="https://oscarestudiante2211.pythonanywhere.com/shiva.PNG" alt="Logo" style="width:50px;height:50px;">
      <h2 style="color:#333333;">Tu pedido se ha realizado !</h2>
      <p style="color:#666666;">¡Hola! {name}</p>
      <p style="color:#666666;">Este es tu pedido realizado el dia : {fecha_hoy} </p>
      {cuerpo_correo}
      <p style="color:#666666;">Gracias,</p>
      <p style="color:#666666;">Tu Nombre</p>
      </body>
      </html>
      """
      msg.attach(MIMEText(html, 'html'))
      server = smtplib.SMTP_SSL(smtp_host, smtp_port)
      server.login(email_usuario, email_password)
      server.sendmail(remitente, destinatario, msg.as_string())
      server.quit()
      print('Correo enviado con éxito')


