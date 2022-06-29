from tkinter import *
import tkinter as tk
from ventanaPrincipal import VentanaSecundaria


class VentanaInicio(Tk):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        # CONFIGURAMOS LA VENTANA
        self.title("Bienvenido")
        self.geometry("990x700")
        self.resizable(0, 0)
        self.configure(background="#2c2e47")

        menuInicio = tk.Menu(self, tearoff=0, bd=0, background="#2c2e47", fg="#eeeee4")
        self.config(menu=menuInicio)
        menu1 = tk.Menu(menuInicio, tearoff=False, background="#2c2e47", fg="#eeeee4")
        menuInicio.add_cascade(label="Inicio", menu=menu1)
        menu1.add_command(label="Descripción", command=self.descripcion)
        menu1.add_command(label="Salir", command=self.salir)

        self.frameIzquierda = tk.Frame(self, background="#2c2e47", bd=1, relief="flat")
        self.frameDerecha = tk.Frame(self, background="#2c2e47", bd=1, relief="flat")

        self.frameInterno1 = tk.Frame(
            self.frameIzquierda, background="#7c6799", bd=1, relief="flat"
        )
        self.frameInterno2 = tk.Frame(
            self.frameIzquierda, background="#7c6799", bd=1, relief="flat"
        )
        self.frameInterno3 = tk.Frame(
            self.frameDerecha, background="#7c6799", bd=1, relief="flat"
        )
        self.frameInterno4 = tk.Frame(
            self.frameDerecha, background="#7c6799", bd=1, relief="flat"
        )

        self.grid_rowconfigure(0, weight=2)
        self.grid_columnconfigure(0, weight=1)
        self.grid_columnconfigure(1, weight=1)

        self.frameIzquierda.grid(
            row=0, column=0, rowspan=1, sticky="nsew", padx=10, pady=20
        )
        self.frameDerecha.grid(
            row=0, column=1, rowspan=1, sticky="nsew", padx=10, pady=20
        )

        self.frameIzquierda.grid_rowconfigure(0, weight=1)
        self.frameIzquierda.grid_rowconfigure(1, weight=2)
        self.frameIzquierda.grid_columnconfigure(0, weight=1)

        self.frameInterno1.grid(
            row=0, column=0, rowspan=1, sticky="nsew", padx=1, pady=5
        )
        self.frameInterno2.grid(
            row=1, column=0, rowspan=1, sticky="nsew", padx=1, pady=5
        )

        self.frameDerecha.grid_rowconfigure(0, weight=1)
        self.frameDerecha.grid_rowconfigure(1, weight=2)
        self.frameDerecha.grid_columnconfigure(0, weight=1)

        self.frameInterno3.grid(
            row=0, column=0, rowspan=1, sticky="nsew", padx=1, pady=5
        )
        self.frameInterno4.grid(
            row=1, column=0, rowspan=1, sticky="nsew", padx=1, pady=5
        )

        # Creamos el requerimiento P3
        self.textoBienvenida = tk.Text(
            self.frameInterno1,
            background="#7c6799",
            bd=-1,
            fg="#eeeee4",
            relief="sunken",
            height=7,
            width=55,
        )
        self.textoBienvenida.insert(
            tk.INSERT, "¡Bienvenido a la aplicación del Hotel Foráneo.!\n"
        )
        self.textoBienvenida.place(x=30, y=97)

        # Creamos el requerimiento P4
        self.fotosSistema = tk.Label(self.frameInterno2, background="#7c6799")
        self.fotosSistema.place(x=10, y=10)

        self.foto = 1
        self.photoSistema = tk.PhotoImage(file="./imagenes/sistema1.png")

        self.labelPhotoHotel = tk.Label(
            self.frameInterno2, image=self.photoSistema, background="white"
        )
        self.labelPhotoHotel.place(x=120, y=30)
        self.labelPhotoHotel.bind("<Enter>", self.informacionEvento)

        self.botonP4 = tk.Button(
            self.frameInterno2,
            text="ira a la siguiente ventana",
            background="#2c2e47",
            fg="#eeeee4",
        )
        self.botonP4.place(relx=0.30, rely=0.85, relwidth=0.40, relheight=0.10)
        self.botonP4.bind("<Button>", self.siguienteVentana)

        # Creamos el requerimiento P6
        self.arregloIntegrante1 = [
            "./imagenes/fotoAndres1.png",
            "./imagenes/fotoAndres2.png",
            "./imagenes/fotoAndres3.png",
            "./imagenes/fotoAndres4.png",
        ]

        self.arregloIntegrante2 = [
            "./imagenes/fotoRoberto1.png",
            "./imagenes/fotoRoberto2.png",
            "./imagenes/fotoRoberto3.png",
            "./imagenes/fotoRoberto4.png",
        ]

        self.arregloIntegrante3 = [
            "./imagenes/fotoCamilo1.png",
            "./imagenes/fotoCamilo2.png",
            "./imagenes/fotoCamilo3.png",
            "./imagenes/fotoCamilo4.png",
        ]
        self.arregloIntegrante4 = [
            "./imagenes/fotoValen1.png",
            "./imagenes/fotoValen2.png",
            "./imagenes/fotoValen3.png",
            "./imagenes/fotoValen4.png",
        ]

        self.photoIntegrante1 = tk.PhotoImage(
            file=self.arregloIntegrante1[0]
        )  # .subsample(2)
        self.photoIntegrante2 = tk.PhotoImage(
            file=self.arregloIntegrante2[0]
        )  # .subsample(2)
        self.photoIntegrante3 = tk.PhotoImage(
            file=self.arregloIntegrante3[0]
        )  # .subsample(2)
        self.photoIntegrante4 = tk.PhotoImage(
            file=self.arregloIntegrante4[0]
        )  # .subsample(2)

        self.labelIntegrante1 = tk.Label(
            self.frameInterno4, image=self.photoIntegrante1, background="#2c2e47"
        )
        self.labelIntegrante2 = tk.Label(
            self.frameInterno4, image=self.photoIntegrante2, background="#2c2e47"
        )
        self.labelIntegrante3 = tk.Label(
            self.frameInterno4, image=self.photoIntegrante3, background="#2c2e47"
        )
        self.labelIntegrante4 = tk.Label(
            self.frameInterno4, image=self.photoIntegrante4, background="#2c2e47"
        )

        self.labelIntegrante1.grid(
            row=0, column=0, rowspan=1, sticky="nsew", padx=2, pady=1
        )
        self.labelIntegrante2.grid(
            row=1, column=0, rowspan=1, sticky="nsew", padx=2, pady=1
        )
        self.labelIntegrante3.grid(
            row=0, column=1, rowspan=1, sticky="nsew", padx=2, pady=1
        )
        self.labelIntegrante4.grid(
            row=1, column=1, rowspan=1, sticky="nsew", padx=2, pady=1
        )

        self.frameInterno4.place(
            # anchor="nsew"
            x=0,
            y=228,
            width=470,
            height=425,
        )

        # Creamos el requerimiento P5
        self.andres = (
            "Nombre: Gonzalo Andrés Santamaría Chilamak\n"
            + "Carrera: Ciencias de la computación\n"
            + "Aficiones: Tecnología, dibujo"
        )

        self.camilo = (
            "Nombre: Camilo Andrés Espíndola Aldana\n"
            + "Carrera: Ingeniería informática\n"
            + "Aficiones: Reagueton, baile"
        )

        self.roberto = (
            "Nombre: Roberto Carlos Pastas Cuaical\n"
            + "Carrera: Ingeniería informática\n"
            + "Aficiones: Autos, bases de datos"
        )

        self.valentina = (
            "Nombre: Valentina Sierra Durango\n"
            + "Carrera: Estadística\n"
            + "Aficiones: Futbol"
        )

        self.listaHojasVida = [self.andres, self.roberto, self.valentina, self.camilo]

        self.indice = 0

        self.hojaVida = self.listaHojasVida[self.indice]
        self.labelP5 = tk.Label(
            self.frameInterno3,
            text=self.hojaVida,
            background="#7c6799",
            fg="#eeeee4",
            justify="left",
        )
        self.labelP5.place(x=30, y=70)
        self.labelP5.bind("<Button>", self.clicHoja)
        self.frameInterno3.place(
            # anchor="nsew"
            x=0,
            y=5,
            width=470,
            height=212,
        )

    def salir(self):
        self.destroy()

    def descripcion(self):

        self.textoBienvenida.delete("1.0", "end")
        self.textoBienvenida.insert(
            tk.INSERT, "\nEsta apliación tiene como finalidad crear reservas,\n"
        )
        self.textoBienvenida.insert(
            tk.INSERT, "modificarlas,  hacer  asignación  de  servicios de \n"
        )
        self.textoBienvenida.insert(
            tk.INSERT, "habitación,  de restaurante, y  llevar un  control\n"
        )
        self.textoBienvenida.insert(
            tk.INSERT, "de gastos que se sumarán a la cuenta.\n"
        )
        self.textoBienvenida.place(x=30, y=57)
        self.textoBienvenida.config(state=tk.DISABLED)

    def siguienteVentana(self, event):
        print("siguiente ventana")
        self.destroy()
        VentanaSecundaria()

    def informacionEvento(self, event):

        if self.foto == 1:
            self.photoSistema = tk.PhotoImage(file="./imagenes/sistema2.png")
            self.labelPhotoHotel.config(image=self.photoSistema)
            self.foto += 1

        elif self.foto == 2:
            self.photoSistema = tk.PhotoImage(file="./imagenes/sistema3.png")
            self.labelPhotoHotel.config(image=self.photoSistema)
            self.foto += 1

        elif self.foto == 3:
            self.photoSistema = tk.PhotoImage(file="./imagenes/sistema1.png")
            self.labelPhotoHotel.config(image=self.photoSistema)
            self.foto = 1

    def cambiarFotos(self, index):
        global photoIntegrante1
        global photoIntegrante2
        global photoIntegrante3
        global photoIntegrante4

        if index == 1:
            photoIntegrante1 = tk.PhotoImage(file=self.arregloIntegrante4[self.indice])
            self.labelIntegrante1.config(image=photoIntegrante1)
            photoIntegrante2 = tk.PhotoImage(file=self.arregloIntegrante3[self.indice])
            self.labelIntegrante2.config(image=photoIntegrante2)
            photoIntegrante3 = tk.PhotoImage(file=self.arregloIntegrante2[self.indice])
            self.labelIntegrante3.config(image=photoIntegrante3)
            photoIntegrante4 = tk.PhotoImage(file=self.arregloIntegrante1[self.indice])
            self.labelIntegrante4.config(image=photoIntegrante4)

        if index == 2:
            photoIntegrante1 = tk.PhotoImage(file=self.arregloIntegrante2[self.indice])
            self.labelIntegrante1.config(image=photoIntegrante1)
            photoIntegrante2 = tk.PhotoImage(file=self.arregloIntegrante4[self.indice])
            self.labelIntegrante2.config(image=photoIntegrante2)
            photoIntegrante3 = tk.PhotoImage(file=self.arregloIntegrante1[self.indice])
            self.labelIntegrante3.config(image=photoIntegrante3)
            photoIntegrante4 = tk.PhotoImage(file=self.arregloIntegrante3[self.indice])
            self.labelIntegrante4.config(image=photoIntegrante4)

        if index == 3:
            photoIntegrante1 = tk.PhotoImage(file=self.arregloIntegrante1[self.indice])
            self.labelIntegrante1.config(image=photoIntegrante1)
            photoIntegrante2 = tk.PhotoImage(file=self.arregloIntegrante2[self.indice])
            self.labelIntegrante2.config(image=photoIntegrante2)
            photoIntegrante3 = tk.PhotoImage(file=self.arregloIntegrante3[self.indice])
            self.labelIntegrante3.config(image=photoIntegrante3)
            photoIntegrante4 = tk.PhotoImage(file=self.arregloIntegrante4[self.indice])
            self.labelIntegrante4.config(image=photoIntegrante4)

        if index == 0:
            photoIntegrante1 = tk.PhotoImage(file=self.arregloIntegrante3[self.indice])
            self.labelIntegrante1.config(image=photoIntegrante1)
            photoIntegrante2 = tk.PhotoImage(file=self.arregloIntegrante1[self.indice])
            self.labelIntegrante2.config(image=photoIntegrante2)
            photoIntegrante3 = tk.PhotoImage(file=self.arregloIntegrante4[self.indice])
            self.labelIntegrante3.config(image=photoIntegrante3)
            photoIntegrante4 = tk.PhotoImage(file=self.arregloIntegrante2[self.indice])
            self.labelIntegrante4.config(image=photoIntegrante4)

    def clicHoja(self, event):

        if self.indice == 0:
            self.hojaVida = self.listaHojasVida[self.indice + 1]
            self.labelP5.config(text=self.hojaVida)
            self.cambiarFotos(self.indice)

        elif self.indice == 1:
            self.hojaVida = self.listaHojasVida[self.indice + 1]
            self.labelP5.config(text=self.hojaVida)
            self.cambiarFotos(self.indice)

        elif self.indice == 2:
            self.hojaVida = self.listaHojasVida[self.indice + 1]
            self.labelP5.config(text=self.hojaVida)
            self.cambiarFotos(self.indice)

        elif self.indice == 3:
            self.hojaVida = self.listaHojasVida[0]
            self.labelP5.config(text=self.hojaVida)
            self.cambiarFotos(self.indice)
            self.indice = 0
            return

        self.indice += 1


if __name__ == "__main__":
    ventana_inicio = VentanaInicio()
    ventana_inicio.mainloop()
