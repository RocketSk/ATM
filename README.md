# ATM
A multi-threaded application. Simulation of the operation of an ATM.

Многопоточное приложение. Имитация работы банкомата.

Есть один экземпляр пластиковой карточки и два типа объектов ATM, которые используют одну и ту же карточку одновременно.
 
Первый ATM, moneyProducer использует карту для пополнения счета периодически (один раз в 0.5-1.5 секунд) на некоторую сумму (25-50 долларов). Сообщение об этом событии и текущее состояние счета выводится на экран.
 
Второй ATM, moneyConsumer использует карту для того, чтобы периодически (один раз в 0.5-1.5 секунд) снимать со счета некоторую сумму (25-50 долларов). Сообщение об этом событии и текущее состояние счета выводится на экран.
 
Программа создает некоторое число (3-5) банкоматов обоих типов, каждый из которых использует один и тот же экземпляр пластиковой карты, и запустить их одновременно на выполнение, каждый в отдельном потоке.
 
В начальный момент времени на счету находится 500 долларов. В случае, если в какой-то момент времени на счету не остается денег или сумма превысит 1000 долларов, программа выводит соответствующее сообщение и завершает работу. 
 
! Обращено внимание на потокобезопасность проектируемых классов. 
! В программе использован интерфейс ExecutorService для запуска потоков на выполнение.
! Формат сообщения об операции: Имя потока, сумма снятия - пополнения, остаток

A multi-threaded application. Simulation of the operation of an ATM.

There is one instance of a plastic card and two types of ATM objects that use the same card at the same time.
 
The first ATM, moneyProducer uses the card to top up the account periodically (once every 0.5-1.5 seconds) for a certain amount ($25-50). A message about this event and the current state of the account is displayed on the screen.
 
The second ATM, moneyConsumer uses the card to periodically (once every 0.5-1.5 seconds) withdraw a certain amount ($25-50) from the account. A message about this event and the current state of the account is shown on the screen.
 
The program creates some number (3-5) of ATMs of both types, each using the same instance of plastic card, and run them simultaneously for execution, each in a separate thread.
 
At the initial point in time there is $500 in the account. If at some point of time there is no money left in the account or the amount exceeds $1000, the program displays a corresponding message and terminates. 
 
! Attention is drawn to the thread-safety of the projected classes. 
! In the program we use ExecutorService interface to run threads.
! Format of operation message: thread name, withdrawal amount - replenishment, balance
