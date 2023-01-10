class Book:
    def __init__(self, title, price, author):
        self.title = title
        self.price = price
        self.author = author

        self.chapters = []

    def add_chapter(self, chapter):
        self.chapters.append(chapter)

    def get_book_page_count(self):
        page_count = 0
        for chapter in self.chapters:
            page_count += chapter.chapter_pages

        return page_count
