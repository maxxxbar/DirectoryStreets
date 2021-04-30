### DirectoryStreets

****
Консольное приложение, принимающее на вход xml-файл и формирующее сводную статистику:

1) Отобразить дублирующиеся записи, с количеством повторений.
2) Посчитать, сколько в каждом городе: 1, 2, 3, 4 и 5 этажных зданий

Принимает файл вида:

~~~~
<?xml version="1.0" encoding="utf-8"?>
<root>
    <item city="Барнаул" street="Дальняя улица" house="56" floor="9" />
    <item city="Барнаул" street="Дальняя улица" house="56" floor="2" />
    <item city="Барнаул" street="Дальняя улица" house="56" floor="2" />
    <item city="Братск" street="Большая Октябрьская улица" house="65" floor="5" />
    <item city="Балаково" street="Барыши, местечко" house="67" floor="2" />
    <item city="Азов" street="Просека, улица" house="156" floor="3" />
    <item city="Видное" street="Авиаторов, улица" house="185" floor="3" />
    <item city="Братск" street="7-я Вишнёвая улица" house="49" floor="5" />
    <item city="Батайск" street="Мостотреста, улица" house="133" floor="4" />
    <item city="Великий Новгород" street="Филимонковская улица" house="44" floor="1" />
    <item city="Абакан" street="2-я Валуевская улица" house="172" floor="3" />
    <item city="Бугульма" street="Варшавское шоссе" house="92" floor="2" />
    <item city="Ачинск" street="Варшавское шоссе" house="39" floor="4" />
    <item city="Балашов" street="Учительский переулок" house="184" floor="1" />
    <item city="Бийск" street="Сиреневая улица" house="14" floor="3" />
    <item city="Армавир" street="Песчаная улица" house="69" floor="1" />
    <item city="Ачинск" street="3-я Барышевская улица" house="154" floor="3" />
    <item city="Астрахань" street="4-й Заречный переулок" house="100" floor="5" />
    <item city="Владивосток" street="Дальняя улица" house="196" floor="3" />
    <item city="Белово" street="Симферопольская улица" house="116" floor="1" />
    <item city="Владивосток" street="Родниковая улица" house="105" floor="1" />
    <item city="Бугульма" street="Маршала Кутахова, улица" house="91" floor="1" />
    <item city="Архангельск" street="Лесхозная улица" house="85" floor="3" />
    <item city="Армавир" street="Евгения Родионова, улица" house="22" floor="4" />
    <item city="Белебей" street="Маршала Кутахова, улица" house="93" floor="1" />
    <item city="Астрахань" street="Еловая улица" house="52" floor="5" />
    <item city="Бийск" street="Вишнёвая улица" house="128" floor="5" />
    <item city="Абакан" street="Симферопольская улица" house="177" floor="2" />
    <item city="Благовещенск" street="Михаила Кондакова, улица" house="31" floor="2" />
    <item city="Братск" street="2-я Катерная улица" house="60" floor="4" />
    <item city="Буйнакск" street="Московская улица" house="142" floor="2" />
    <item city="Балаково" street="Лагерная улица" house="122" floor="4" />
    <item city="Абакан" street="Барышевская улица" house="69" floor="3" />
    <item city="Балашов" street="1-й Богородский переулок" house="7" floor="1" />
    <item city="Бердск" street="4-я Майская улица" house="53" floor="3" />
</root>
~~~~
