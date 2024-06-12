import wikipediaapi

wiki = wikipediaapi.Wikipedia('en') 
page = wiki.page("Python_(programming_language)")
if page.exists():
    print("Title:", page.title)
    print()

    # Imprimir el contenido del artículo
    print("Content:")
    print(page.text)
else:
    print("Page not found.")
