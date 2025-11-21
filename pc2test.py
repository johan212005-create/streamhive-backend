import time
import random
from datetime import datetime

# Base de datos simulada de usuarios referidos
referidos_pendientes = [
    {"email": "amigo1@gmail.com", "invitado_por": "juan.perez"},
    {"email": "colega2@hotmail.com", "invitado_por": "maria.dev"},
    {"email": "student3@uni.edu.pe", "invitado_por": "carlos.sys"}
]

def enviar_correo_viral(email, usuario_origen):
    """Simula el envío de un correo transaccional usando SendGrid API"""
    print(f"[{datetime.now()}] --------------------------------")
    print(f"INFO: Procesando invitación para: {email}")
    print(f"DEBUG: Generando link único de referido...")
    
    # Simulación de latencia de red (espera 0.5 segundos)
    time.sleep(0.5) 
    
    referral_code = random.randint(10000, 99999)
    print(f"SUCCESS: Correo enviado! (Template: 'Tu amigo {usuario_origen} te regaló Premium')")
    print(f"METADATA: Code={referral_code} | Status=200 OK")
    return True

def ejecutar_motor_viral():
    print(">>> INICIANDO MOTOR DE GROWTH HACKING (StreamHive) <<<")
    print(">>> Buscando nuevos referidos en la cola de mensajes RabbitMQ...\n")
    
    processed_count = 0
    for usuario in referidos_pendientes:
        exito = enviar_correo_viral(usuario["email"], usuario["invitado_por"])
        if exito:
            processed_count += 1
            
    print(f"\n>>> CICLO COMPLETADO. Emails enviados: {processed_count}")
    print(">>> Actualizando métricas en Dashboard...")

if __name__ == "__main__":
    ejecutar_motor_viral()