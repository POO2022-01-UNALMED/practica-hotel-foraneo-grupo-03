from tkinter import ttk
import tkinter as tk
from tkinter import messagebox
from tkinter.ttk import Combobox
from tkinter import *
from fieldFrame import *


class VentanaSecundaria(tk.Tk):

    # en_uso = False  # si hay una ventanaSecundaria abierta

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        # self.title("Ventana aplicación")
        # self.option_add("*tearOff", FALSE)
        self.title("Hotel Foráneo")
        self.geometry("990x700")
        self.ventanaInicio = None
        self.focus()

        self.frameIzquierda = tk.Frame(self, background="#7c6799", bd=1, relief="flat")
        self.frameDerecha = tk.Frame(self, background="#2c2e47", bd=1, relief="flat")
        self.frameCentroReserva = tk.Frame(self, bd=1, relief="flat")
        self.frameCentroHuesped = tk.Frame(self, background="red", bd=1, relief="flat")
        self.frameCentroBusqueda = tk.Frame(
            self, background="green", bd=1, relief="flat"
        )
        self.frameCentro = tk.Frame(self, background="#2c2e47", bd=1, relief="flat")

        self.frameIzquierda.grid(
            row=0, column=0, rowspan=2, sticky="nsew", padx=0, pady=0
        )
        self.frameCentro.grid(row=0, column=1, rowspan=2, sticky="nsew", padx=0, pady=0)
        self.frameDerecha.grid(
            row=0, column=2, rowspan=2, sticky="nsew", padx=1, pady=0
        )

        self.frameCentroReserva.grid(rowspan=2, sticky="nsew", padx=0, pady=0)
        self.frameCentroHuesped.grid(rowspan=2, sticky="nsew", padx=0, pady=0)
        self.frameCentroBusqueda.grid(rowspan=2, sticky="nsew", padx=0, pady=0)

        self.grid_rowconfigure(0, weight=2)
        self.grid_rowconfigure(1, weight=2)

        self.grid_columnconfigure(0, weight=1)
        self.grid_columnconfigure(1, weight=3)
        self.grid_columnconfigure(2, weight=1)

        for frame in (
            self.frameCentroReserva,
            self.frameCentroHuesped,
            self.frameCentroBusqueda,
        ):
            frame.grid(row=0, column=1)

        # Contenido frameIzquierda
        self.photoReserva = tk.PhotoImage(file="./imagenes/reserva.png")
        self.btnReserva = tk.Button(
            self.frameIzquierda,
            text="Reserva",
            anchor="w",
            width=150,
            height=30,
            bd=0,
            highlightthickness=0,
            bg="#7c6799",
            activebackground="#302759",
            fg="white",
            activeforeground="white",
            image=self.photoReserva,
            compound="left",
            cursor="hand2",
            command=lambda: self.raise_frame(self.frameCentroReserva),
        ).place(x=10, y=20)

        self.photoHuesped = tk.PhotoImage(file="./imagenes/huesped.png")
        self.btnHuesped = tk.Button(
            self.frameIzquierda,
            text="Huesped",
            anchor="w",
            width=150,
            height=30,
            bd=0,
            highlightthickness=0,
            bg="#7c6799",
            activebackground="#302759",
            fg="white",
            activeforeground="white",
            image=self.photoHuesped,
            compound="left",
            cursor="hand2",
            command=lambda: self.raise_frame(self.frameCentroHuesped),
        ).place(x=10, y=80)

        self.photoBusqueda = tk.PhotoImage(file="./imagenes/busqueda.png")
        self.btnBusqueda = tk.Button(
            self.frameIzquierda,
            text="Búsqueda",
            anchor="w",  # texto a la izquierda
            width=150,
            height=30,
            bd=0,
            highlightthickness=0,
            bg="#7c6799",
            activebackground="#302759",
            fg="white",
            activeforeground="white",
            image=self.photoBusqueda,
            compound="left",  # Imagen a la izquierda
            borderwidth=0,
            cursor="hand2",
            command=lambda: self.raise_frame(self.frameCentroBusqueda),
        ).place(x=10, y=140)

        # Contenido frameDerecha
        # Create an object of tkinter ImageTk
        self.photoAdmin = tk.PhotoImage(file="./imagenes/admin.png")
        self.photoCirculo = tk.PhotoImage(file="./imagenes/circulo.png")
        self.labelPhoto = tk.Label(
            self.frameDerecha, image=self.photoAdmin, background="#2c2e47"
        )
        self.labelCirculo = tk.Label(
            self.frameDerecha, image=self.photoCirculo, background="#2c2e47"
        )

        # labelCirculo.place(x=0, y=20)
        self.labelPhoto.place(x=35, y=70)

        self.nombreAdmin = "Pepito Perez"
        self.LabelTextoAdmin = tk.Label(
            self.frameDerecha,
            text=self.nombreAdmin + "\n@Admin",
            font=("FreeMono", 14, "bold"),
            background="#2c2e47",
            foreground="#eeeee4",
        )
        self.LabelTextoAdmin.place(x=30, y=220)

        self.datosAdmin = (
            "Hora conexión: 23:00\n" + "\nTiempo: 5.5 Horas\n" + "\nNotificaciones: 2"
        )
        self.LabelTextoAdmin = tk.Label(
            self.frameDerecha,
            text=self.datosAdmin,
            font=("FreeMono", 10),
            justify="left",
            background="#2c2e47",
            foreground="white",
        )
        self.LabelTextoAdmin.place(x=10, y=280)

        # Contenido frameCentro
        self.photoHotel = tk.PhotoImage(file="./imagenes/hotel.png")
        self.labelPhotoHotel = tk.Label(
            self.frameCentro, image=self.photoHotel, background="#2c2e47"
        )
        self.labelPhotoHotel.place(x=45, y=110)

        # Contenido frameCentroReserva
        self.style = ttk.Style()
        self.style.configure("TNotebook", background="#2c2e47", borderwidth=0)
        self.style.configure(
            "TNotebook.Tab",
            background="#2c2e47",
            foreground="gray",
            lightcolor="black",
            borderwidth=0,
        )

        self.tabControl = ttk.Notebook(self.frameCentroReserva)
        self.tab1 = tk.Frame(self.tabControl, background="#2c2e47", bd=0)
        self.tab1.config(borderwidth="0")
        self.tab2 = tk.Frame(self.tabControl, background="#2c2e47")

        self.tabControl.add(self.tab1, text="Crear")
        self.tabControl.add(self.tab2, text="Editar")
        self.tabControl.pack(expand=1, fill="both")

        self.crearNombreLabel = tk.Label(
            self.tab1,
            text="Nombre:",
            font=("FreeMono", 12),
            background="#2c2e47",
            foreground="white",
        ).place(x=20, y=30)

        self.crearNombreEntry = tk.Entry(
            self.tab1,
            width=18,
            background="#eeeee4",
        ).place(x=130, y=30)

        self.crearApellidoLabel = tk.Label(
            self.tab1,
            text="Apellido:",
            font=("FreeMono", 12),
            background="#2c2e47",
            foreground="white",
        ).place(x=320, y=30)

        self.crearApellidoEntry = tk.Entry(
            self.tab1,
            width=18,
            background="#eeeee4",
        ).place(x=420, y=30)

        self.crearDocumentoLabel = tk.Label(
            self.tab1,
            text="Documento:",
            font=("FreeMono", 12),
            background="#2c2e47",
            foreground="white",
        ).place(x=20, y=80)

        self.crearDocumentoEntry = tk.Entry(
            self.tab1,
            width=18,
            background="#eeeee4",
        ).place(x=130, y=80)

        self.tabControl.pack()

        self.mainloop()

    def raise_frame(frame):
        frame.tkraise()

    def volver(self):
        self.destroy()
