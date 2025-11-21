from locust import HttpUser, task, between

class StreamHiveUser(HttpUser):
    # Simula un tiempo de espera entre acciones de 1 a 5 segundos (comportamiento humano)
    wait_time = between(1, 5)

    @task(3)
    def view_homepage(self):
        # El usuario entra al home
        self.client.get("/api/v1/catalog/home")

    @task(1)
    def search_video(self):
        # El usuario busca "Java"
        self.client.get("/api/v1/catalog/search?q=Java")

    @task(5)
    def watch_video(self):
        # El usuario ve un video (simulación de carga de stream)
        # Se pide el manifiesto HLS
        self.client.get("/api/v1/stream/video_12345/manifest.m3u8")

    def on_start(self):
        # Se ejecuta al iniciar: Login simulado
        self.client.post("/api/v1/auth/login", json={"username":"test", "password":"123"})
