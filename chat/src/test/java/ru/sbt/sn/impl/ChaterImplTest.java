package ru.sbt.sn.impl;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sbt.sn.IChater;
import ru.sbt.sn.ISender;
import ru.sbt.sn.User;
import ru.sbt.sn.exception.ChatDenyException;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ChaterImplTest {
    private static ISender mockService;
    private static IChater chater;

    private User sender;
    private User receiver;

    @BeforeClass
    public static void setUpClass() {
        mockService = mock( ISender.class );
        chater = new ChaterImpl( mockService );
    }

    @Before
    public void setUp() {
        sender = User.builder()
                .id( "1" )
                .name( "один" )
                .age( 1 )
                .build();
        receiver = User.builder()
                .id( "2" )
                .name( "два" )
                .age( 2 )
                .build();
    }

    @Test
    public void testSendChatMessage() throws ChatDenyException {
        chater.sendChatMessage( sender, receiver, "этот текст должен отправиться" );
        verify( mockService ).send( any() );
    }

    @Test(expected = ChatDenyException.class)
    public void testSendChatMessageDenyError() throws ChatDenyException {
        chater.sendChatMessage( sender, sender, "этот текст не должен отправиться" );
        fail( "Произошла неподдерживаемая отправка сообщения" );
    }
}
