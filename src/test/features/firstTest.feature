# language: ru

Функция: Создание командировки

Сценарий: Создание командировки для проверки ошибки валидации

  Дано я авторизован в системе
  И проверяю заголовок меню
  И перехожу в список командировок
  И нажимаю Создать командировку
  И проверяю заголовок страницы создания командировки
  И выбираю отдел
  И выбираю компанию
  И нажимаю чекбокс Заказать билеты
  И заполняю город отправления
  И заполняю город прибытия
  И заполняю дату отправления
  И заполняю дату прибытия
  И проверяю заполнение полей
  И нажимаю Сохранить и выйти
  Тогда я должен увидеть ошибку валидации незаполненных обязательных полей