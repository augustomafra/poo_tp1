# Programacao Orientada a Objetos
# 2018-1
#
# Trabalho Intermediario 1
#
# Andre Lage
# Augusto Mafra
#

COMPILE = javac
DEBUG = -g
DESTINY_DIR = .
BLOCK_WARNINGS = -Werror # Treat any compilation warning as error

.SUFFIXES: .java .class

.java.class:
	$(COMPILE) $(DEBUG) -d $(DESTINY_DIR) $(BLOCK_WARNINGS) $*.java

SOURCE = Matriz.java

all: classes

classes: $(SOURCE:.java=.class)

clean:
	$(RM) ./*.class
